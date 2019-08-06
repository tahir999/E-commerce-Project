package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int suppID;

	private String suppAddress;

	private String suppContactName;

	private String suppEmail;

	private String suppName;

	private String suppPhone;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="supplier")
	private List<Product> products;

	//bi-directional many-to-one association to Purchorder
	@OneToMany(mappedBy="supplier")
	private List<Purchorder> purchorders;

	public Supplier() {
	}

	public int getSuppID() {
		return this.suppID;
	}

	public void setSuppID(int suppID) {
		this.suppID = suppID;
	}

	public String getSuppAddress() {
		return this.suppAddress;
	}

	public void setSuppAddress(String suppAddress) {
		this.suppAddress = suppAddress;
	}

	public String getSuppContactName() {
		return this.suppContactName;
	}

	public void setSuppContactName(String suppContactName) {
		this.suppContactName = suppContactName;
	}

	public String getSuppEmail() {
		return this.suppEmail;
	}

	public void setSuppEmail(String suppEmail) {
		this.suppEmail = suppEmail;
	}

	public String getSuppName() {
		return this.suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppPhone() {
		return this.suppPhone;
	}

	public void setSuppPhone(String suppPhone) {
		this.suppPhone = suppPhone;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSupplier(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSupplier(null);

		return product;
	}

	public List<Purchorder> getPurchorders() {
		return this.purchorders;
	}

	public void setPurchorders(List<Purchorder> purchorders) {
		this.purchorders = purchorders;
	}

	public Purchorder addPurchorder(Purchorder purchorder) {
		getPurchorders().add(purchorder);
		purchorder.setSupplier(this);

		return purchorder;
	}

	public Purchorder removePurchorder(Purchorder purchorder) {
		getPurchorders().remove(purchorder);
		purchorder.setSupplier(null);

		return purchorder;
	}

}