package spring.project.SpringCouponSystem.repositories;

import java.util.ArrayList;
import java.util.Date;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.entities.CouponType;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	@Transactional
	 @Modifying
	    @Query("UPDATE Coupon c SET c.amount = :amount, c.endDate = :endDate,"
	    		+ "c.image = :image, c.message =:message, c.price =:price, c.startDate =:startDate,"
	    		+ "c.title =:title, c.type =:type WHERE c.id = :couponId")
	     void updateCoupon(@Param("couponId") int couponId, @Param("amount") int amount,
	    		@Param("endDate") Date endDate,@Param("image") String image, @Param("message") String message,
	    		@Param("price") double price, @Param("startDate") Date startDate, @Param("title") String title,
	    		@Param("type") CouponType couponType);
	
	@Modifying
	@Query("delete from Coupon c where c.company.id =:companyId")
	public void deleteBycompanyId(@Param("companyId") int companyId);

	
	ArrayList<Coupon> findByType(CouponType couponType);
	
	public ArrayList<Coupon> findAllByCompanyId(int companyid);

	

	
	
	
}
