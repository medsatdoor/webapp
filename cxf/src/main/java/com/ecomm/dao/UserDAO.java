package com.ecomm.dao;

import java.util.List;

import com.ecomm.dbentity.User;

public interface UserDAO {

	List<User> listAllUsers();
	User listUserById(String id);
	User listUserByMailId(String email);
	User listUserByMobileNumber(Integer mobileNumber);
	User addUser(User user);
	User updateUser(User user);	
}
