package com.ecomm.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dao.utils.HibernateProperties;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;


public class ProductDAOImpl implements ProductDAO {
	
	//private static Session session = DatabaseSessionManager.getDatabaseSession();
	
	// Operation with single entity
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

	

	/**
	 * Bulk data with batch processing
	 */
	@Override
	public List<Product> addProductList(List<Product> productList) {
		int batchSize = HibernateProperties.getBatchSize();
		Session session = DatabaseSessionManager.getDatabaseSession();
		List<Product> addedProducts = new ArrayList();
		for(int i=0;i<productList.size();++i){
			String id = (String)session.save(productList.get(i));
			addedProducts.add((Product)session.get(Product.class, id));
			if(i==batchSize){
				session.flush();
		        session.clear();
			}
		}
		return addedProducts;
	}
	
}
