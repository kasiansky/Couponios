package spring.project.SpringCouponSystem.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.entities.CouponType;
import spring.project.SpringCouponSystem.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Transactional
	 @Modifying
	    @Query("UPDATE Customer c SET c.customerName = :customerName, c.password = :password"
	    		+ " WHERE c.id =:customerId")
	     int updateCustomer(@Param("customerId") int customerId, @Param("customerName") String customerName,
	    		@Param("password") String password);

//	ArrayList<Customer> findAllByNameAndPassword(String name, String password);

	Customer findBycustomerNameAndPassword(String customerName, String password);
	@Transactional
	 
	    @Query("select coupon from Customer customer Join customer.coupons coupon where coupon.id =:couponId And customer.id =:customerId")
	public Coupon getCustomerCoupon(@Param("couponId") int couponId, @Param("customerId")int customerId);

	@Transactional
	@Query("select c.coupons from Customer c where c.id= ?1")
	ArrayList<Coupon> getAllPurchasedCoupons(int customerId);

	@Transactional
	@Query("select c from Coupon c Join c.customers customer where c.type =:type and customer.id =:customerId")
	ArrayList<Coupon> getAllPurchasedCouponsByType(@Param("customerId")int customerId, @Param("type")CouponType type);

	@Transactional
	@Query("select c from Coupon c Join c.customers customer where customer.id =:customerId and c.price =:price")
	ArrayList<Coupon> getAllPurchasedCouponsByPrice(@Param("customerId")int customerId, @Param("price")double price);

	
	
}
