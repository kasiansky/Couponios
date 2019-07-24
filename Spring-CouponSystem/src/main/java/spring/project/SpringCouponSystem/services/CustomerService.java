package spring.project.SpringCouponSystem.services;

import java.util.ArrayList;

import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.entities.CouponType;
import spring.project.SpringCouponSystem.entities.Customer;
import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.exceptions.DbDataNotFoundException;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.exceptions.UniqueValueException;

public interface CustomerService {
	

	
     void purchaseCoupon(int couponId, int customerId) throws DbDataNotFoundException;

	 ArrayList<Coupon>getAllPurchasedCoupons(int customerId);

	 ArrayList<Coupon> getAllPurchasedCouponsByType(int customerId, CouponType type);

	 ArrayList<Coupon> getAllPurchasedCouponsByPrice(int customerId, double price);

	LoggedUser login(String name, String password, ClientType clientType) throws Exception;

	

	

	
}
