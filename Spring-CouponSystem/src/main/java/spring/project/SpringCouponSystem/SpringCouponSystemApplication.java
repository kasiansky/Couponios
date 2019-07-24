package spring.project.SpringCouponSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.services.AdminServiceImpl;
import spring.project.SpringCouponSystem.services.CompanyServiceImpl;

@SpringBootApplication
@ServletComponentScan
public class SpringCouponSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCouponSystemApplication.class, args);
		
		
		
	}

}
