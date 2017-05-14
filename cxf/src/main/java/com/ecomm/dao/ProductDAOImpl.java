package com.ecomm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public class ProductDAOImpl implements ProductDAO {
	
	//private static Session session = DatabaseSessionManager.getDatabaseSession();
	
	public List<Product> listAllProducts() throws EcommException {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Product").list();
	}

	public Product listProductById(String id) throws EcommException{
		return (Product)DatabaseSessionManager.getDatabaseSession().get(Product.class, id);
	}

	public Product addProduct(Product product) throws EcommException{
		return null;
	}
	
	public void updateProduct(Product product) throws EcommException {
	}
	
	public void deleteProduct(Product product) throws EcommException {

	}
}
