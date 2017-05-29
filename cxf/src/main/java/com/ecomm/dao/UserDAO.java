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
	User updateUserByUserId(String userId);
	User updateUserByMailId(String email);
	User updateUserByMobileNumber(Integer mobileNumber);
	
	void deleteUser(User user);
	void deleteUserByUserId(String userId);
	void deleteUserByEmailId(String email);
	void deleteUserByMobieNumber(Integer mobileNumber);
	
	void deleteAllUsers();
	
}
