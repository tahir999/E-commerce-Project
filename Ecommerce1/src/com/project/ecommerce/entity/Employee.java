package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empID;

	private String email;

	private String fName;

	private String lName;

	private String title;

	//bi-directional many-to-one association to Grp
	@ManyToOne
	@JoinColumn(name="groupID")
	private Grp grp;

	//bi-directional many-to-one association to Purchorder
	@OneToMany(mappedBy="employee")
	private List<Purchorder> purchorders;

	public Employee() {
	}

	public int getEmpID() {
		return this.empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return this.lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Grp getGrp() {
		return this.grp;
	}

	public void setGrp(Grp grp) {
		this.grp = grp;
	}

	public List<Purchorder> getPurchorders() {
		return this.purchorders;
	}

	public void setPurchorders(List<Purchorder> purchorders) {
		this.purchorders = purchorders;
	}

	public Purchorder addPurchorder(Purchorder purchorder) {
		getPurchorders().add(purchorder);
		purchorder.setEmployee(this);

		return purchorder;
	}

	public Purchorder removePurchorder(Purchorder purchorder) {
		getPurchorders().remove(purchorder);
		purchorder.setEmployee(null);

		return purchorder;
	}

}