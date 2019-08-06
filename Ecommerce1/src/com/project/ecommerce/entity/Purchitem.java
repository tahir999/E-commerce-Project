package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the purchitem database table.
 * 
 */
@Entity
@NamedQuery(name="Purchitem.findAll", query="SELECT p FROM Purchitem p")
public class Purchitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchItemId;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="prodID")
	private Product product;

	//bi-directional many-to-one association to Purchorder
	@ManyToOne
	@JoinColumn(name="purchID")
	private Purchorder purchorder;

	public Purchitem() {
	}

	public int getPurchItemId() {
		return this.purchItemId;
	}

	public void setPurchItemId(int purchItemId) {
		this.purchItemId = purchItemId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Purchorder getPurchorder() {
		return this.purchorder;
	}

	public void setPurchorder(Purchorder purchorder) {
		this.purchorder = purchorder;
	}

}