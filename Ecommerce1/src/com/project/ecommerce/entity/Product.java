package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findByAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prodID;

	private int popularity;

	private float price;

	private String prodName;

	private int stockLevel;

	//bi-directional many-to-one association to Basketproduct
	@OneToMany(mappedBy="product")
	private List<Basketproduct> basketproducts;

	//bi-directional many-to-one association to Orderline
	@OneToMany(mappedBy="product")
	private List<Orderline> orderlines;

	//bi-directional many-to-one association to Basket
	@ManyToOne
	@JoinColumn(name="basketId")
	private Basket basket;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="catID")
	private Category category;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="suppID")
	private Supplier supplier;

	//bi-directional many-to-one association to Purchitem
	@OneToMany(mappedBy="product")
	private List<Purchitem> purchitems;

	//bi-directional many-to-many association to Purchorder
	@ManyToMany(mappedBy="products")
	private List<Purchorder> purchorders;

	public Product() {
	}

	public int getProdID() {
		return this.prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public int getPopularity() {
		return this.popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getStockLevel() {
		return this.stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public List<Basketproduct> getBasketproducts() {
		return this.basketproducts;
	}

	public void setBasketproducts(List<Basketproduct> basketproducts) {
		this.basketproducts = basketproducts;
	}

	public Basketproduct addBasketproduct(Basketproduct basketproduct) {
		getBasketproducts().add(basketproduct);
		basketproduct.setProduct(this);

		return basketproduct;
	}

	public Basketproduct removeBasketproduct(Basketproduct basketproduct) {
		getBasketproducts().remove(basketproduct);
		basketproduct.setProduct(null);

		return basketproduct;
	}

	public List<Orderline> getOrderlines() {
		return this.orderlines;
	}

	public void setOrderlines(List<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

	public Orderline addOrderline(Orderline orderline) {
		getOrderlines().add(orderline);
		orderline.setProduct(this);

		return orderline;
	}

	public Orderline removeOrderline(Orderline orderline) {
		getOrderlines().remove(orderline);
		orderline.setProduct(null);

		return orderline;
	}

	public Basket getBasket() {
		return this.basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Purchitem> getPurchitems() {
		return this.purchitems;
	}

	public void setPurchitems(List<Purchitem> purchitems) {
		this.purchitems = purchitems;
	}

	public Purchitem addPurchitem(Purchitem purchitem) {
		getPurchitems().add(purchitem);
		purchitem.setProduct(this);

		return purchitem;
	}

	public Purchitem removePurchitem(Purchitem purchitem) {
		getPurchitems().remove(purchitem);
		purchitem.setProduct(null);

		return purchitem;
	}

	public List<Purchorder> getPurchorders() {
		return this.purchorders;
	}

	public void setPurchorders(List<Purchorder> purchorders) {
		this.purchorders = purchorders;
	}

}