package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderline database table.
 * 
 */
@Entity
@NamedQuery(name="Orderline.findAll", query="SELECT o FROM Orderline o")
public class Orderline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderlineId;

	private int quantity;

	private float totalPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderID")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="prodID")
	private Product product;

	public Orderline() {
	}

	public int getOrderlineId() {
		return this.orderlineId;
	}

	public void setOrderlineId(int orderlineId) {
		this.orderlineId = orderlineId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}