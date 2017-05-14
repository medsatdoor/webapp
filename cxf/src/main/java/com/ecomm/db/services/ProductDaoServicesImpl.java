package com.ecomm.db.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ecomm.dao.ProductDAO;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;


/**
 * 
 * Spring recommends that you only annotate concrete classes (and methods of concrete classes) 
 * with the @Transactional annotation, as opposed to annotating interfaces. 
 * You certainly can place the @Transactional annotation on an interface 
 * (or an interface method), but this works only as you would expect it to 
 * if you are using interface-based proxies. The fact that Java annotations are not 
 * inherited from interfaces means that if you are using class-based proxies 
 * (proxy-target-class="true") or the weaving-based aspect (mode="aspectj"), 
 * then the transaction settings are not recognized by the proxying and weaving infrastructure, 
 * and the object will not be wrapped in a transactional proxy, which would be decidedly bad.
 * 
 * */
public class ProductDaoServicesImpl {

	private ProductDAO productDAO;
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	/**
	 * PROPAGATION & ISOLATION STRATEGY & XML NEEDS TO BE UPDATED... 
	 * NOT DONE YET!!!
	 * */
	
	@Transactional
	public List<Product> listAllProducts() throws EcommException {
		return productDAO.listAllProducts();
	}

	@Transactional
	public Product listProductsById(String id) throws EcommException {
		return productDAO.listProductById(id);
	}
}
