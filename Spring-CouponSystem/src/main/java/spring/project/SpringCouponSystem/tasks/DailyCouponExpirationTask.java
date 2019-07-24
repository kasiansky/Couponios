package spring.project.SpringCouponSystem.tasks;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.services.CompanyServiceImpl;
@Scope(value = "singleton")
public class DailyCouponExpirationTask implements Runnable {
	@Autowired
	private CompanyServiceImpl companyServiceImpl ;
	public static ArrayList<Coupon> coupons;
	private boolean quit = false;

	public DailyCouponExpirationTask() {
		
	}

	@Override
	public void run() {
		
		while (!quit) {
			
			DailyCouponExpirationTask.coupons = companyServiceImpl.getAllCoupons();
			
			Date now = new Date(System.currentTimeMillis());
			for (Coupon coupon : coupons) {
				
				if (now.after(coupon.getEndDate())) {
					try {
						companyServiceImpl.removeCoupon(coupon);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
			}
				try {
					System.out.println("DailyTask started");
					Thread.sleep(60*60*24*1000);
					System.out.println("DailyTask ended");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
	}}
		
	

	

	public void stopTask() {
		quit = Thread.interrupted();
	}

}
