package com.project.ecommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grp database table.
 * 
 */
@Entity
@NamedQuery(name="Grp.findAll", query="SELECT g FROM Grp g")
public class Grp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int groupID;

	private String empDepartment;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="grp")
	private List<Employee> employees;

	public Grp() {
	}

	public int getGroupID() {
		return this.groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getEmpDepartment() {
		return this.empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setGrp(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setGrp(null);

		return employee;
	}

}