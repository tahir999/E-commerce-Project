package com.project.ecommerce.entity;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserModel
 */
@Stateless
@LocalBean
    public class UserModel {
	@PersistenceContext(name = "Ecommerce1")
	private EntityManager em;
	
     UserModel() {
    	
    }
 
	public void addUser(Useraccount user) {
		em.persist(user);
		
	}
	 public void deleteUser(Useraccount user) {
		em.remove(user);
		
	}
	
	 public void editUser(Useraccount user) {
		em.merge(user);
		
	}
	 
	 public List<Useraccount>findByUser(){
			return em.createNamedQuery("Useraccount.findByAll", Useraccount.class).getResultList();
		}
 

}
