package spring.project.SpringCouponSystem.services;

import java.util.ArrayList;
import java.util.Optional;

import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.entities.CouponType;
import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.exceptions.UniqueValueException;

public interface CompanyService {
	
	
	void createCoupon(Coupon coupon, int companyId) throws UniqueValueException;

	void removeCoupon(int couponId) throws MySQLException;

	
	Optional<Coupon> getCoupon(int id);
	
	ArrayList<Coupon> getCouponByType(CouponType couponType);

	LoggedUser login(String companyName, String password, ClientType type);

	ArrayList<Coupon> getAllCoupons(int companyid);

	void updateCoupon(Coupon coupon, int companyId) throws MySQLException;

	
}
