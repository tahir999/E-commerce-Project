package com.project.ecommerce.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "productcontrol")
@RequestScoped
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Product> productList = new ArrayList<>();
	private Product pro = new Product();
	
	@EJB
	private ProductModel productModel;

	public List<Product> getProductList() {
		productList = productModel.findByProduct();
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	public void saveProduct(Product product) {
		productModel.addProduct(product);	
	}
	public void deleteProduct(Product product) {
		productModel.deleteProduct(product);	
	}
	public void editProduct(Product product) {
		productModel.editProduct(product);	
	}
}
