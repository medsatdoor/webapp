package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;

import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;


public interface ProductDAO {
	
	List<Product> listAllProducts();

	Product listProductById(String id);

	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	Product addOrUpdateProduct(Product product);
	
	void deleteProduct(Product product);

	void deleteAllProducts();

	//void addProductList(List<Product> products);

}
