package com.ecomm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;

import org.hibernate.Session;


public class ProductDAOImpl implements ProductDAO {
	
	//private static Session session = DatabaseSessionManager.getDatabaseSession();
	
	public List<Product> listAllProducts() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Product").list();
	}

	public Product listProductById(String id) {
		return (Product)DatabaseSessionManager.getDatabaseSession().get(Product.class, id);
	}

	public Product addProduct(Product product) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		String id = (String)session.save(product);
		return (Product)session.get(Product.class, id);
	}
	
	public Product updateProduct(Product product) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.update(product);
		return (Product)session.get(Product.class, product.getId());
	}
	
	public Product addOrUpdateProduct(Product product) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.saveOrUpdate(product);
		return (Product)session.get(Product.class, product.getId());
	}
	
	public void deleteProduct(Product product) {
		DatabaseSessionManager.getDatabaseSession().delete(product);
	}

	public void deleteAllProducts() {
		DatabaseSessionManager.getDatabaseSession().createQuery("delete from Product").executeUpdate();
	}
}
