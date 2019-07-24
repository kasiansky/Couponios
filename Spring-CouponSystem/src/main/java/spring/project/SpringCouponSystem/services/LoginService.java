package spring.project.SpringCouponSystem.services;

import org.springframework.beans.factory.annotation.Autowired;

import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.LoggedUser;

public class LoginService {
	
	@Autowired
	private AdminServiceImpl admin;
	@Autowired
	private CompanyServiceImpl company;
	@Autowired 
	private CustomerServiceImpl customer;
	
	public LoggedUser login(String name, String password, ClientType clientType) throws Exception {
		
		switch(clientType) {
		case ADMIN :
			return admin.login(name, password, clientType);
		case COMPANY :
			return company.login(name, password, clientType);
		case CUSTOMER :
			return customer.login(name, password, clientType);
		default:
			return null;
			
		}
		
		
	}
}
