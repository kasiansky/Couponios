package spring.project.SpringCouponSystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.entities.CouponType;
import spring.project.SpringCouponSystem.entities.Customer;
import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.exceptions.UniqueValueException;
import spring.project.SpringCouponSystem.repositories.CompanyRepository;
import spring.project.SpringCouponSystem.repositories.CouponRepository;
import spring.project.SpringCouponSystem.repositories.CustomerRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public CompanyServiceImpl() {

	}

	
	@Override
	public void createCoupon(Coupon coupon, int companyId) throws UniqueValueException {
		Company company = companyRepository.findById(companyId).get();
		coupon.setCompany(company);
		
		couponRepository.save(coupon);
	}

	@Transactional
	@Override
	public void removeCoupon(int couponId) throws MySQLException {
		
		couponRepository.deleteById(couponId);

	}

	@Override
	public void updateCoupon(Coupon coupon, int companyId) throws MySQLException {
		
//		if(companyId != couponRepository.find){
//			System.out.println("not autorize !!!");
//		}
		couponRepository.updateCoupon(coupon.getId(),coupon.getAmount(),coupon.getEndDate(),coupon.getImage(),coupon.getMessage(),coupon.getPrice(),coupon.getStartDate(),coupon.getTitle(),coupon.getType());
		

	}

	@Override
	public ArrayList<Coupon> getCouponByType(CouponType couponType) {
		ArrayList<Coupon> coupons = couponRepository.findByType(couponType);		
		return coupons;
	}

	@Override
	public ArrayList<Coupon> getAllCoupons(int companyid) {
		
		return couponRepository.findAllByCompanyId(companyid);
	}

	@Override
	public LoggedUser login(String companyName, String password, ClientType type) {
		
		if(!type.equals(ClientType.COMPANY)){
			return null;
		}
		ArrayList<Company> company = companyRepository.findBycompanyNameAndPassword(companyName, password);
		
		if(company!= null && company.size() == 1){
			System.out.println("Hello " + company.get(0).getCompanyName());
		return new LoggedUser(company.get(0).getId(),companyName,password, type);
		}else
		return null;
//		
	}

	@Override
	public Optional<Coupon> getCoupon(int id) {
		
		return couponRepository.findById(id);
	}


	


	


	

	



}
