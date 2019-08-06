package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the delivery database table.
 * 
 */
@Entity
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deliveryId;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date devDate;

	private String devMethod;

	private String devStatus;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="userEmail")
	private Customer customer;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderID")
	private Order order;

	public Delivery() {
	}

	public int getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDevDate() {
		return this.devDate;
	}

	public void setDevDate(Date devDate) {
		this.devDate = devDate;
	}

	public String getDevMethod() {
		return this.devMethod;
	}

	public void setDevMethod(String devMethod) {
		this.devMethod = devMethod;
	}

	public String getDevStatus() {
		return this.devStatus;
	}

	public void setDevStatus(String devStatus) {
		this.devStatus = devStatus;
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

}