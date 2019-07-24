package spring.project.SpringCouponSystem.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String customerName;
	private String password;
	@JsonIgnore
	@ManyToMany ( cascade= CascadeType.PERSIST, fetch=FetchType.LAZY)
	private Collection<Coupon> coupons = new ArrayList<>(); 

	public Customer(){}
	public Customer(int id, String customerName, String password) {
		
		this.id = id;
		this.customerName = customerName;
		this.password = password;
		
	}
	
	public Customer(String customerName, String password) {
		super();
		this.customerName = customerName;
		this.password = password;
		
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ArrayList<Coupon> getCoupons() {
		return (ArrayList<Coupon>) coupons;
	}
	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + customerName + ", password=" + password + ", coupons=" + coupons
				+ "]";
	}
	public void addCoupon(Coupon checkCoupon) {
		coupons.add(checkCoupon);
		
	}
	
}
