package com.ecomm.dao;

import java.util.List;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;


public interface ProductDAO {
	
	List<Product> listAllProducts() throws EcommException;
	
	Product listProductById(String id) throws EcommException;
	
	Product addProduct(Product product) throws EcommException;
	
	void updateProduct(Product product) throws EcommException;
	
	void deleteProduct(Product product) throws EcommException;

}
