package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the useraccount database table.
 * 
 */
@Entity
@NamedQuery(name="Useraccount.findByAll", query="SELECT u FROM Useraccount u")
public class Useraccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userEmail;

	private String userPassword;

	//bi-directional one-to-one association to Customer
	@OneToOne(cascade=CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(name="userEmail", referencedColumnName = "userEmail")
	private Customer customer;

	public Useraccount() {
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}