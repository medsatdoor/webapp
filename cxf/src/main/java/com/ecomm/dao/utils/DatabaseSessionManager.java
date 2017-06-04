package com.ecomm.dao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.ecomm.commonutility.logger.EcommLogger;

/**
 * ************************************************************************************************************
 * REASON: Hibernate Template should not be used 
 * Pro: They perform common setup routines for you, 
 * 		let you skip the boilerplate and concentrate on the logic you want.
 * Con: you are coupling your application tightly to the spring framework. 
 * 		For this reason, Spring recommends that HibernateTemplate no longer be used.
 * 		*** Cannot use the stored procedures or SQL qeries
 * 		*** http://www.baeldung.com/persistence-layer-with-spring-and-hibernate
 * 		*** http://stackoverflow.com/questions/5104765/why-is-hibernatedaosupport-not-recommended
 * Specifically, what HibernateTemplate did for you was to automatically open and close sessions 
 * With the advent of the Contextual session support in Hibernate un-neccessary binding with spring classes 
 * with hibernate has made the use of template obsolete. 
 * Perhaps, templates can be used if someone is using JDBC 
 * ************************************************************************************************************
 * */
public class DatabaseSessionManager {
	
	private static SessionFactory sessionFactory;

	private DatabaseSessionManager(){
		// No Initialization in the application
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	// Application can get only the access to the session resource
	// Application should not create their own session,
	// instead should use the current contextual session
	public static Session getDatabaseSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
