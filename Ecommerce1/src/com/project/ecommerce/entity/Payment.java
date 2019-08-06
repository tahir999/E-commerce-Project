package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;

	private float amount;

	private String payStatus;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="userEmail")
	private Customer customer;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderID")
	private Order order;

	//bi-directional many-to-one association to Paymentmethod
	@ManyToOne
	@JoinColumn(name="methodID")
	private Paymentmethod paymentmethod;

	public Payment() {
	}

	public int getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Paymentmethod getPaymentmethod() {
		return this.paymentmethod;
	}

	public void setPaymentmethod(Paymentmethod paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

}