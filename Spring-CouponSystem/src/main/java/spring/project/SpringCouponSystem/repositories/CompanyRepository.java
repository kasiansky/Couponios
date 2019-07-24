package spring.project.SpringCouponSystem.repositories;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.entities.Coupon;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	ArrayList<Company> findBycompanyNameAndPassword(String companyName, String password);
	@Transactional
	 @Modifying
	    @Query("UPDATE Company c SET c.companyName = :companyName, c.password = :password,"
	    		+ "c.email = :email  WHERE c.id = :companyId")
	   public int updateCompany(@Param("companyId") int companyId, @Param("companyName") String companyName,
	    		@Param("password") String password,@Param("email") String email);
	
	@Query("select coupons from Company c where c.id =:companyId  ")
	public Collection<Coupon> getCoupons(@Param("companyId") int companyId);
}
