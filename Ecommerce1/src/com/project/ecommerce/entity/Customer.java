package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findByAll", query="SELECT c FROM Customer c")
@NamedQuery(name="Customer.find", query="SELECT c.userEmail FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String userEmail;

	@Column(name="firstname")
	private String fName;

	@Column(name="homeAddress")
	private String homeAdress;

	@Column(name="lastName")
	private String lName;

	@Column(name="passw")
	private String pass;

	@Column(name="phoneNumber")
	private String phone;

	@Column(name="titles")
	private String title;
	//bi-directional many-to-one association to Basket
	@OneToMany(mappedBy="customer")
	private List<Basket> baskets;

	//bi-directional many-to-one association to Delivery
	@OneToMany(mappedBy="customer")
	private List<Delivery> deliveries;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	private List<Order> orders;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="customer")
	private List<Payment> payments;

	//bi-directional many-to-one association to Paymentmethod
	@OneToMany(mappedBy="customer")
	private List<Paymentmethod> paymentmethods;

	//bi-directional one-to-one association to Useraccount
	@OneToOne(mappedBy="customer")
	private Useraccount useraccount;

	public Customer() {
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getHomeAdress() {
		return homeAdress;
	}

	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Useraccount getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

	public List<Basket> getBaskets() {
		return this.baskets;
	}

	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}

	public Basket addBasket(Basket basket) {
		getBaskets().add(basket);
		basket.setCustomer(this);

		return basket;
	}

	public Basket removeBasket(Basket basket) {
		getBaskets().remove(basket);
		basket.setCustomer(null);

		return basket;
	}

	public List<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public Delivery addDelivery(Delivery delivery) {
		getDeliveries().add(delivery);
		delivery.setCustomer(this);

		return delivery;
	}

	public Delivery removeDelivery(Delivery delivery) {
		getDeliveries().remove(delivery);
		delivery.setCustomer(null);

		return delivery;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setCustomer(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setCustomer(null);

		return payment;
	}

	public List<Paymentmethod> getPaymentmethods() {
		return this.paymentmethods;
	}

	public void setPaymentmethods(List<Paymentmethod> paymentmethods) {
		this.paymentmethods = paymentmethods;
	}

	public Paymentmethod addPaymentmethod(Paymentmethod paymentmethod) {
		getPaymentmethods().add(paymentmethod);
		paymentmethod.setCustomer(this);

		return paymentmethod;
	}

	public Paymentmethod removePaymentmethod(Paymentmethod paymentmethod) {
		getPaymentmethods().remove(paymentmethod);
		paymentmethod.setCustomer(null);

		return paymentmethod;
	}

}