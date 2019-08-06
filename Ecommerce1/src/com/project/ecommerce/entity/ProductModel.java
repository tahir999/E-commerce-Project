package com.project.ecommerce.entity;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ProductModel
 */
@Stateless
@LocalBean
public class ProductModel {
	@PersistenceContext(name = "Ecommerce1")
	private EntityManager em;

	
    public ProductModel() {
        // TODO Auto-generated constructor stub
    }
    public void addProduct(Product product) {
		em.persist(product);
		
	}
    public void deleteProduct(Product product) {
		em.remove(product);
		
	}public void editProduct(Product product) {
		em.merge(product);
		
	}
	 public List<Product>findByProduct(){
			return em.createNamedQuery("Product.findByAll", Product.class).getResultList();
		}
}
