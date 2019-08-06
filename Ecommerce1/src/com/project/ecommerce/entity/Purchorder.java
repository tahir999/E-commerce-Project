package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the purchorder database table.
 * 
 */
@Entity
@NamedQuery(name="Purchorder.findAll", query="SELECT p FROM Purchorder p")
public class Purchorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchID;

	private int quantity;

	//bi-directional many-to-one association to Purchitem
	@OneToMany(mappedBy="purchorder")
	private List<Purchitem> purchitems;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empID")
	private Employee employee;

	//bi-directional many-to-many association to Product
	@ManyToMany
	@JoinTable(
		name="purchitem"
		, joinColumns={
			@JoinColumn(name="purchID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="prodID")
			}
		)
	private List<Product> products;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="suppID")
	private Supplier supplier;

	public Purchorder() {
	}

	public int getPurchID() {
		return this.purchID;
	}

	public void setPurchID(int purchID) {
		this.purchID = purchID;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Purchitem> getPurchitems() {
		return this.purchitems;
	}

	public void setPurchitems(List<Purchitem> purchitems) {
		this.purchitems = purchitems;
	}

	public Purchitem addPurchitem(Purchitem purchitem) {
		getPurchitems().add(purchitem);
		purchitem.setPurchorder(this);

		return purchitem;
	}

	public Purchitem removePurchitem(Purchitem purchitem) {
		getPurchitems().remove(purchitem);
		purchitem.setPurchorder(null);

		return purchitem;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}