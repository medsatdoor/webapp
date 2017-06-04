package com.ecomm.db.services;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ecomm.dao.UserDAO;
import com.ecomm.dbentity.Product;
import com.ecomm.dbentity.User;
import com.ecomm.exception.EcommException;

public class UserDaoServicesImpl {

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public List<User> listAllUsers() throws EcommException {
		try{
			return userDAO.listAllUsers();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public User listUsersbyId(String userId) throws EcommException {
		try{
			User user =  userDAO.listUserById(userId);
			if(user == null){
				throw new EcommException(404, "No User found with userid: "+userId);
			}
			return user;
		}catch(EcommException e){
			throw e;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public User listUserByMailId(String email) throws EcommException {
		try{
			User user =  userDAO.listUserByMailId(email);
			if(user == null){
				throw new EcommException(404, "No User found with email: "+email);
			}
			return user;
		}catch(EcommException e){
			throw e;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public User listUserByMobileNumber(int mobileNumber) throws EcommException {
		try{
			User user =  userDAO.listUserByMobileNumber(mobileNumber);
			if(user == null){
				throw new EcommException(404, "No User found with mobile number: "+mobileNumber);
			}
			return user;
		}catch(EcommException e){
			throw e;
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public User addUser(User dbuser) throws EcommException {
		try{
			dbuser.setNameIndex(dbuser.getName().charAt(0));
			dbuser.setRegisteredDate(new Date());
			dbuser.setState("ACTIVE");
			dbuser.setType("CUSTOMER");
			dbuser.setBalance(0);
			return userDAO.addUser(dbuser);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public User updateUser(User dbuser) throws EcommException{
		try{
			return userDAO.updateUser(dbuser);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
}
