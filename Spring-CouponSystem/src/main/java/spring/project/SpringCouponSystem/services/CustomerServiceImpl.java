package spring.project.SpringCouponSystem.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.entities.CouponType;
import spring.project.SpringCouponSystem.entities.Customer;
import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.exceptions.DbDataNotFoundException;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.exceptions.UniqueValueException;
import spring.project.SpringCouponSystem.repositories.CouponRepository;
import spring.project.SpringCouponSystem.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired 
	private CouponRepository couponRepository;

	@Override
	public LoggedUser login(String name, String password, ClientType clientType) throws Exception {
		Customer customer = customerRepository.findBycustomerNameAndPassword(name, password);
		if( customer!=null && clientType.equals(ClientType.CUSTOMER) ){
			LoggedUser log =  new LoggedUser(customer.getId(),name,password, clientType);
			System.out.println(log.toString());
			return log;
		
		}else throw new Exception("client not found");
		
	}

	@Override
	public void purchaseCoupon(int couponId, int customerId) throws DbDataNotFoundException {
		Coupon checkCoupon = couponRepository.findById(couponId).get();
		
		Coupon customerCoupon = customerRepository.getCustomerCoupon(couponId, customerId);
		Customer customer = customerRepository.findById(customerId).get();
		if (checkCoupon == null){
			throw new DbDataNotFoundException("Coupon with ID : " + couponId + " is not found");
		}
			if (customerCoupon != null){
			throw new DbDataNotFoundException("Coupon  : " + couponId + "  already purchased");
		}
			if(checkCoupon.getAmount() <= 0){
			throw new ValidationException("Coupon is out of stock");
		}
			if(checkCoupon.getEndDate().before(new Date(System.currentTimeMillis())))
			throw new ValidationException("Coupon is expired " + checkCoupon.getEndDate());
		customer.addCoupon(checkCoupon);
		checkCoupon.addCustomer(customer);
		checkCoupon.setAmount(checkCoupon.getAmount()-1);
		couponRepository.save(checkCoupon);
		customerRepository.save(customer);
	}

	@Override
	public ArrayList<Coupon> getAllPurchasedCoupons(int customerId) {
		
		return customerRepository.getAllPurchasedCoupons(customerId);
		
	}

	@Override
	public ArrayList<Coupon> getAllPurchasedCouponsByType(int customerId, CouponType type) {
		return customerRepository.getAllPurchasedCouponsByType(customerId, type);
		
	}

	@Override
	public ArrayList<Coupon> getAllPurchasedCouponsByPrice(int customerId, double price) {
		return customerRepository.getAllPurchasedCouponsByPrice(customerId, price);
		
	}
}
