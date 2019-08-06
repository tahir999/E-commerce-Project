package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paymentmethod database table.
 * 
 */
@Entity
@NamedQuery(name="Paymentmethod.findAll", query="SELECT p FROM Paymentmethod p")
public class Paymentmethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int methodID;

	private int cardNo;

	private int csv;

	private int expiry;

	private String payType;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="paymentmethod")
	private List<Payment> payments;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="userEmail")
	private Customer customer;

	public Paymentmethod() {
	}

	public int getMethodID() {
		return this.methodID;
	}

	public void setMethodID(int methodID) {
		this.methodID = methodID;
	}

	public int getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public int getCsv() {
		return this.csv;
	}

	public void setCsv(int csv) {
		this.csv = csv;
	}

	public int getExpiry() {
		return this.expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setPaymentmethod(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setPaymentmethod(null);

		return payment;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}