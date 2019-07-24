package spring.project.SpringCouponSystem.services;

import java.util.ArrayList;
import java.util.Optional;

import spring.project.SpringCouponSystem.entities.ClientType;
import spring.project.SpringCouponSystem.entities.Company;
import spring.project.SpringCouponSystem.entities.Customer;
import spring.project.SpringCouponSystem.entities.LoggedUser;
import spring.project.SpringCouponSystem.exceptions.MySQLException;
import spring.project.SpringCouponSystem.exceptions.UniqueValueException;

public interface AdminService {
	
	void createCompany(Company company) throws UniqueValueException;

	void removeCompany(int companyId) throws MySQLException;

	void updateCompany(Company company) throws MySQLException;
	
	Company getCompany(int id);
	
	ArrayList<Company> getAllCompanies();
	
	void createCustomer(Customer customer) throws UniqueValueException;

	void removeCustomer(int customerId)throws MySQLException;

	void updateCustomer(Customer customer) throws MySQLException;

	Customer getCustomer(int id);

	ArrayList<Customer> getAllCustomer();
	
	LoggedUser login(String name, String password, ClientType clientType);

}
