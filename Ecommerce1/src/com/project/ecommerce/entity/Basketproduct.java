package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the basketproduct database table.
 * 
 */
@Entity
@NamedQuery(name="Basketproduct.findAll", query="SELECT b FROM Basketproduct b")
public class Basketproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int basketProductID;

	//bi-directional many-to-one association to Basket
	@ManyToOne
	@JoinColumn(name="basketID")
	private Basket basket;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="prodID")
	private Product product;

	public Basketproduct() {
	}

	public int getBasketProductID() {
		return this.basketProductID;
	}

	public void setBasketProductID(int basketProductID) {
		this.basketProductID = basketProductID;
	}

	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}