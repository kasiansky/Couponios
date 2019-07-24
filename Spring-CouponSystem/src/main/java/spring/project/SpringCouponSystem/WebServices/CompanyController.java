package spring.project.SpringCouponSystem.WebServices;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.services.CompanyServiceImpl;

public class CompanyController {

	@Autowired
	private CompanyServiceImpl companyService;
	
	private LoggedUser loggedUser(HttpSession session) {
		return (spring.project.SpringCouponSystem.entities.LoggedUser) session.getAttribute("LoggedUser");
		
	}
}
