package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;

import com.ecomm.dbentity.Product;
import com.ecomm.dbentity.User;
import com.ecomm.dao.utils.DatabaseSessionManager;

public class UserDAOImpl implements UserDAO {

	public List listAllUsers() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from User").list();
	}

	public User listUserById(String id) {
		return (User) DatabaseSessionManager.getDatabaseSession().get(User.class, id);
	}

	public User listUserByMailId(String email) {
		return (User) DatabaseSessionManager.getDatabaseSession()
				.createQuery("from User where emailAddress=:email")
				.setParameter("email", email).list().get(0);
	}

	public User listUserByMobileNumber(Integer mobileNumber) {
		return (User) DatabaseSessionManager.getDatabaseSession()
				.createQuery("from User where mobileNumber=:mno")
				.setParameter("mno", mobileNumber).list().get(0);
	}

	public User addUser(User user) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		String id = (String) session.save(user);
		return (User) session.get(User.class, id);
	}

	public User updateUser(User user) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.update(user);
		return (User) session.get(User.class, user.getUserId());
	}

	public User addOrUpdateUser(User user) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.saveOrUpdate(user);
		return (User) session.get(User.class, user.getUserId());
	}
}
