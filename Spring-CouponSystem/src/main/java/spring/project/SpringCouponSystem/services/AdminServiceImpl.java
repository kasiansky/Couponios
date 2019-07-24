package spring.project.SpringCouponSystem.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.entities.Customer;
import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.repositories.CompanyRepository;
import spring.project.SpringCouponSystem.repositories.CouponRepository;
import spring.project.SpringCouponSystem.repositories.CustomerRepository;
/**
 * this class is used for operations as Admin
 * @author Mark
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CouponRepository couponRepository;
	
	public AdminServiceImpl() {
	}
	/**
	 * this function used for create company 
	 * @param company
	 */
	
	public void createCompany(Company company){
		
		companyRepository.save(company);
		
	}
	@Transactional
	public void removeCompany(int companyId){
//		if(!companyRepository.getCoupons(companyId).isEmpty()){
//		couponRepository.deleteBycompanyId(companyId);
//		}
		companyRepository.deleteById(companyId);
		
	}
public void updateCompany(Company company){
		companyRepository.updateCompany(company.getId(), company.getCompanyName(), company.getPassword(), company.getEmail());
	}

public Company getCompany(int id){
	
	return companyRepository.findById(id).get();
	
}
public ArrayList<Company> getAllCompanies(){
	return (ArrayList<Company>) companyRepository.findAll();
	 
	 
	
}
public void createCustomer(Customer customer){
	
	customerRepository.save(customer);
	
}
public void removeCustomer(int customerId){
	
	customerRepository.deleteById( customerId);
	
}	
public void updateCustomer(Customer customer){
	
	customerRepository.updateCustomer(customer.getId(), customer.getCustomerName(), customer.getPassword());
	
}
public Customer getCustomer(int id){
	
	return customerRepository.findById(id).get();	
}
public ArrayList<Customer> getAllCustomer(){
	
	return (ArrayList<Customer>) customerRepository.findAll();
	
}

@Override
public LoggedUser login(String name, String password, ClientType clientType) {
	if (name.equals("admin") && password.equals("1234") && clientType.equals(ClientType.ADMIN)){
		System.out.println("login as admin success");
		return new LoggedUser(1,password, password, clientType) ;
		
	}else {
		System.out.println("Client not found");
		return null;
	}
	
}


	
		
	
	
	

}
