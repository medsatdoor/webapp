package com.ecomm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProductDAOImpl implements ProductDAO {
	
	public List<Product> listAllProducts() throws EcommException {
		Session session = DatabaseSessionManager.getDatabaseSession();
		try{
			return session.createQuery("from Product").list();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	public Product listProductById(String id) throws EcommException{
		Session session = DatabaseSessionManager.getDatabaseSession();
		try{
			Product product = (Product)session.get(Product.class, id); 
			EcommLogger.info("id:"+id+", product: "+product);
			if(product == null){
				throw new EcommException(404, "product id not found: "+id+" DAO Hibernate error!!!!");
			}
			return product;
		}catch(EcommException e){
			throw e;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	public Product addProduct(Product product) throws EcommException{
		Session session = DatabaseSessionManager.getDatabaseSession();
		try{
			Transaction transaction = session.beginTransaction();
			
			return null;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
	
	public void updateProduct(Product product) throws EcommException {
		Session session = DatabaseSessionManager.getDatabaseSession();
		try{
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
	
	public void deleteProduct(Product product) throws EcommException {
		Session session = DatabaseSessionManager.getDatabaseSession();
		try{
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
}
