package com.project.ecommerce.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "usercontrol")
@RequestScoped
public class UserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Useraccount> userList = new ArrayList<>();
	private Useraccount ua = new Useraccount();
	
	@EJB
	private UserModel userModel;

	public List<Useraccount>getUserList(){
		userList = userModel.findByUser();
		return userList;
	}
	public void setUserList(List<Useraccount> userList) {
		this.userList = userList;
	}
	public Useraccount getUa() {
		return ua;
	}
	public void setUa(Useraccount ua) {
		this.ua = ua;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public void saveUser(Useraccount user) {
		userModel.addUser(user);
		
	}
	 public void deleteUser(Useraccount user) {
		 userModel.deleteUser(user);
		
	}
	 public void editEmployee(Useraccount user) {
		 userModel.editUser(user);
		
	}

}
