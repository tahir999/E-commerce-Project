package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the basket database table.
 * 
 */
@Entity
@NamedQuery(name="Basket.findAll", query="SELECT b FROM Basket b")
public class Basket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int basketId;

	private float price;

	private int quantity;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="userEmail")
	private Customer customer;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;

	//bi-directional many-to-one association to Basketproduct
	@OneToMany(mappedBy="basket")
	private List<Basketproduct> basketproducts;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="basket")
	private List<Product> products;

	public Basket() {
	}

	public int getBasketId() {
		return this.basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public List<Basketproduct> getBasketproducts() {
		return this.basketproducts;
	}

	public void setBasketproducts(List<Basketproduct> basketproducts) {
		this.basketproducts = basketproducts;
	}

	public Basketproduct addBasketproduct(Basketproduct basketproduct) {
		getBasketproducts().add(basketproduct);
		basketproduct.setBasket(this);

		return basketproduct;
	}

	public Basketproduct removeBasketproduct(Basketproduct basketproduct) {
		getBasketproducts().remove(basketproduct);
		basketproduct.setBasket(null);

		return basketproduct;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setBasket(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setBasket(null);

		return product;
	}

}