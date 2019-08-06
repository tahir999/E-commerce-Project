package com.project.ecommerce.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "controller")
@RequestScoped
public class Managebe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Customer> customerList = new ArrayList<>();
	private Customer cust = new Customer();
	
	@EJB
	private CustomerModel custModel;
	
	public Customer getCust() {
		return cust;
	}
	public CustomerModel getCs() {
		return custModel;
	}

	public void setCs(CustomerModel custModel) {
		this.custModel = custModel;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}
	public List<Customer>getCustomerList(){
		customerList = custModel.findByCustomers();
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public CustomerModel getCustModel() {
		return custModel;
	}

	public void setCustModel(CustomerModel custModel) {
		this.custModel = custModel;
		
	}
	public void saveCustomer(Customer cus) {
		custModel.addCustomer(cus);
	   }
	
	public void addCustomer(Customer cus) {
		custModel.addCustomer(cus);
	   }
	
	public void deleteCustomer(Customer cus) {
		custModel.deleteCustomer(cus);
	
	   }
	public void editCustomer(Customer cus) {
		custModel.editCustomer(cus);
	   } 
	
	}
	

