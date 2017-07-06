package com.ecomm.db.services;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ecomm.dbentity.Product;
import com.ecomm.dbentity.ProductSpecification;


public class TestProductDaoServices {

	public static void main(String args[]) {

		SessionFactory factory;

		try {
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			
			Product product = new Product("AASA", "T1", "S!", 100, new Date(), 10);
			
			product.setProductSpecifications(new HashMap(){
				{
					put("p1", new ProductSpecification("v1"));
					put("p2", new ProductSpecification("v2"));
					put("p3", new ProductSpecification("v3"));
					put("p4", new ProductSpecification("v4"));
				}
			});
			
			session.save(product);
			System.out.println("done..");
			transaction.commit();
			
			Product employees = (Product) session.createQuery("FROM Product").list().get(0);
			System.out.println(employees);
			
			session.close();
			
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}
}
