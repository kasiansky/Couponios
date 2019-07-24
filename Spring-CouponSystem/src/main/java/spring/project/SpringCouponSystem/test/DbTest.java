package spring.project.SpringCouponSystem.test;

import java.sql.Date;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import spring.project.SpringCouponSystem.SpringCouponSystemApplication;
import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.entities.Coupon;
import spring.project.SpringCouponSystem.entities.CouponType;
import spring.project.SpringCouponSystem.entities.Customer;
import spring.project.SpringCouponSystem.exceptions.DbDataNotFoundException;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.exceptions.UniqueValueException;
import spring.project.SpringCouponSystem.services.AdminServiceImpl;
import spring.project.SpringCouponSystem.services.CompanyServiceImpl;
import spring.project.SpringCouponSystem.services.CustomerServiceImpl;

public class DbTest {

	public static void main(String[] args) {
ConfigurableApplicationContext context = SpringApplication.run(SpringCouponSystemApplication.class, args);
		Scanner input = new Scanner(System.in);
		Date now = new Date(System.currentTimeMillis());

		Company company = new Company("Nike","123456","lala");
		Company company2 = new Company(2,"Nike","123456","lala");
		Customer customer = new Customer(1,"Mark","123");
		Coupon coupon = new Coupon(1,"NikeCoupon",Date.valueOf("2019-07-08"),Date.valueOf("2019-06-08"),10,CouponType.SPORTS,"Sale 80%",100.0,"image");

				
		AdminServiceImpl admin = (AdminServiceImpl) context.getBean("adminServiceImpl");
		//WORKING
//		admin.login("admin", "1234", ClientType.ADMIN);
		//WORKING BUT needs to do validation
//		admin.createCompany(company2);
		//WORKING BUT NEED RO EXPLORE BETTER WAY TO GIVE PARAMETRE
//		admin.getCompany(input.nextInt());
		//	WORKING
//		admin.getAllCompanies();
		//WORKING
//		admin.removeCompany(2);
		//WORKING BUT need to improve logic 
//		admin.updateCompany(company2);
		//WORKING
//		admin.createCustomer(customer);
		//WORKING BUT need to know how to give id from user in client side
//		admin.removeCustomer(2);
		//WORKING BUT need to improve logic
//		admin.updateCustomer(customer);
		//WORKING BUT need to improve logic
//		admin.getCustomer(customer.getId());
		//WORKING
//		admin.getAllCustomer();
		
		
		CompanyServiceImpl companyClient = (CompanyServiceImpl) context.getBean("companyServiceImpl");
		// WORKING
	//	companyClient.login(company.getCompanyName(), company.getPassword(), ClientType.COMPANY);
		
		 //Working 
//		try {
//			companyClient.createCoupon(coupon, 3);
//		} catch (UniqueValueException e) {
//			e.getMessage();
//		}
		// WORKING
//		try {
//			companyClient.removeCoupon(4);
//		} catch (MySQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// UPDATE IS OF COUPON IS WORKING BUT need to check if need the companyId
//		try {
//			companyClient.updateCoupon(coupon, 2);
//		} catch (MySQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//WORKING
//		companyClient.getCoupon(coupon.getId());
		//WORKING
//		companyClient.getCouponByType(coupon.getType());
		//WORKING BUT WHILE DOING QUERY GETTING COMPANY TOO
//		companyClient.getAllCoupons(3);
		
		
		CustomerServiceImpl customerClient = (CustomerServiceImpl) context.getBean("customerServiceImpl");
		//WORKING BUT NEED TO CHANGE LOGGED USER PARAMETERS
//		try {
//			customerClient.login(customer.getCustomerName(), customer.getPassword(), ClientType.CUSTOMER);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//WORKING BUT NEED TO HANDLE EXCEPTIONS
//		try {
//			customerClient.purchaseCoupon(coupon.getId(), customer.getId());
//		} catch (DbDataNotFoundException e) {
//			
//			e.getMessage();
//		}
		
		//WORKING
//		customerClient.getAllPurchasedCoupons(1);
		//WORKING
//		customerClient.getAllPurchasedCouponsByType(customer.getId(), coupon.getType());
		//WORKING
//		customerClient.getAllPurchasedCouponsByPrice(customer.getId(),coupon.getPrice());
	}

}
