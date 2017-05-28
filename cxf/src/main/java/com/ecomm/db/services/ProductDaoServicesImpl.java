package com.ecomm.db.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.utils.DatabaseSessionManager;
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
	
	@Transactional
	public List<Product> listAllProducts() throws EcommException {
		try{
			return productDAO.listAllProducts();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Product listProductsById(String id) throws EcommException {
		try{
			Product product =  productDAO.listProductById(id);
			if(product == null){
				throw new EcommException(404, "No Product found with id: "+id);
			}
			return product;
		}catch(EcommException e){
			throw e;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Product addProduct(Product product) throws EcommException{
		try{
			return productDAO.addProduct(product);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
	
	@Transactional
	public Product updateProduct(Product product) throws EcommException{
		try{
			return productDAO.updateProduct(product);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
	
	@Transactional
	public Product addOrUpdateProduct(Product product) throws EcommException{
		try{
			return productDAO.addOrUpdateProduct(product);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
	
	@Transactional
	public void deleteProduct(Product product) throws EcommException{
		try{
			productDAO.deleteProduct(product);
		}catch(Exception e){
			throw new EcommException(500, e);
		}	
	}
	
	@Transactional
	public void deleteAllProducts() throws EcommException {
		try{
			productDAO.deleteAllProducts();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
	
	// Adding reusable multi-steped services 
	
	@Transactional
	public void deleteProductById(String id) throws EcommException{
		try{
			Product product = productDAO.listProductById(id);
			productDAO.deleteProduct(product);
		}catch(Exception e){
			throw new EcommException(500, e);
		}	
	}

	// Bulk operations
	@Transactional
	public void addProductList(List<Product> products) throws EcommException {
		try{
			List<Product> list = productDAO.addProductList(products);
			EcommLogger.info(list.toString());
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

}
