package com.project.ecommerce.entity;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CustomerBean
 */

@Stateless
@LocalBean
public class CustomerModel {
	@PersistenceContext(name = "Ecommerce1")
	private EntityManager em;
 
	public void addCustomer(Customer cust) {
		em.persist(cust);
		
	}
	public void deleteCustomer(Customer cust) {
		em.remove(cust);
		
	}
	public void editCustomer(Customer cust) {
		em.merge(cust);
		
	}
	public List<Customer>findByCustomers(){
		return em.createNamedQuery("Customer.findByAll", Customer.class).getResultList();
	}

}
