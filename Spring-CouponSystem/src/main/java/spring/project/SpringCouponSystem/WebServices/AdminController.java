package spring.project.SpringCouponSystem.WebServices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.entities.Customer;
import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.exceptions.CompanySystemException;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.exceptions.UniqueValueException;
import spring.project.SpringCouponSystem.services.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl admin;
	
	private LoggedUser loggedUser(HttpSession session) {
		return (spring.project.SpringCouponSystem.entities.LoggedUser) session.getAttribute("LoggedUser");
		
	}
	
	
	
	@RequestMapping( path = "create", method = RequestMethod.POST )
	public Company createCompany( @RequestBody Company company) throws UniqueValueException {
		admin.createCompany(company);
		return company;
	}


	
	@GetMapping("/getCompany/{id}")
	Company getCompany(@PathVariable int id) {
		
		return admin.getCompany(id);
	}
	@RequestMapping(path = "getAllCompanies", method = RequestMethod.GET)
	Collection<Company> getAllCompanies() {
		
		return admin.getAllCompanies();
	}
	@RequestMapping( path = "createCustomer", method = RequestMethod.POST)
	void createCustomer(Customer customer) throws UniqueValueException {
		admin.createCustomer(customer);
	}
	@RequestMapping( path = "removeCustomer", method = RequestMethod.DELETE)
	void removeCustomer(int customerId)throws MySQLException {
		admin.removeCustomer(customerId);
	}
	@RequestMapping( path = "updateCustomer" , method = RequestMethod.PUT)
	void updateCustomer(Customer customer) throws MySQLException {
		admin.updateCustomer(customer);
	}
	@RequestMapping( path = "getCustomer", method = RequestMethod.GET)
	Customer getCustomer(int id) {
		return admin.getCustomer(id);
	}
	@RequestMapping ( path = "getAllCustomers" , method = RequestMethod.GET)
	ArrayList<Customer> getAllCustomer() {
		return admin.getAllCustomer();
	}
//	@RequestMapping ( path = "")
//	LoggedUser login(String name, String password, ClientType clientType);

	
}
