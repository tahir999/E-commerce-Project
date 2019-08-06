package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderID;

	@Temporal(TemporalType.DATE)
	private Date orderDate;

	private String orderStatus;

	//bi-directional many-to-one association to Basket
	@OneToMany(mappedBy="order")
	private List<Basket> baskets;

	//bi-directional many-to-one association to Delivery
	@OneToMany(mappedBy="order")
	private List<Delivery> deliveries;

	//bi-directional many-to-one association to Orderline
	@OneToMany(mappedBy="order")
	private List<Orderline> orderlines;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="userEmail")
	private Customer customer;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="order")
	private List<Payment> payments;

	public Order() {
	}

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Basket> getBaskets() {
		return this.baskets;
	}

	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}

	public Basket addBasket(Basket basket) {
		getBaskets().add(basket);
		basket.setOrder(this);

		return basket;
	}

	public Basket removeBasket(Basket basket) {
		getBaskets().remove(basket);
		basket.setOrder(null);

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
		delivery.setOrder(this);

		return delivery;
	}

	public Delivery removeDelivery(Delivery delivery) {
		getDeliveries().remove(delivery);
		delivery.setOrder(null);

		return delivery;
	}

	public List<Orderline> getOrderlines() {
		return this.orderlines;
	}

	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

	public Orderline addOrderline(Orderline orderline) {
		getOrderlines().add(orderline);
		orderline.setOrder(this);

		return orderline;
	}

	public Orderline removeOrderline(Orderline orderline) {
		getOrderlines().remove(orderline);
		orderline.setOrder(null);

		return orderline;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setOrder(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setOrder(null);

		return payment;
	}

}