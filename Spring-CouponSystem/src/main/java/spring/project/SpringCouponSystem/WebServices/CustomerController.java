package spring.project.SpringCouponSystem.WebServices;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.services.CustomerServiceImpl;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	private LoggedUser loggedUser(HttpSession session) {
		return (spring.project.SpringCouponSystem.entities.LoggedUser) session.getAttribute("LoggedUser");
		
	}
	
	

}
