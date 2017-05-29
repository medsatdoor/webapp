package com.ecomm.ws.services;

import java.util.List;

import javax.ws.rs.core.Response;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.db.services.UserDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.services.utils.beanmappers.ProductMapper;
import com.ecomm.ws.services.utils.beanmappers.UserMapper;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.wsentity.Products;
import com.ecomm.wsentity.Users;

public class UserServicesImpl implements UserServices {

	private UserDaoServicesImpl userDaoServices;
	
	public void setUserDaoServices(UserDaoServicesImpl userDaoServices) {
		this.userDaoServices = userDaoServices;
	}
	
	public Response listAllUsers() {
		try{ 
			List<com.ecomm.dbentity.User> dbuserList = userDaoServices.listAllUsers();
			EcommLogger.info("dbusers: "+dbuserList);
			return EcommResponse.getResponseOk(UserMapper.mapDbToWs(dbuserList));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listUsersbyId(String userId) {
		if (userId == null) {
			throw new EcommWebException(404, "Not found any user with userid= null");
		}
		try {
			com.ecomm.dbentity.User dbuser = userDaoServices.listUsersbyId(userId);
			if (dbuser == null) {
				throw new EcommWebException(404, "User id: "+userId+" was not found");
			}
			com.ecomm.wsentity.User wsuser = UserMapper.mapDbToWs(dbuser);
			return EcommResponse.getResponseOk(wsuser);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listUserByEmail(String email) {
		if (email == null) {
			throw new EcommWebException(404, "Not found any user with email= null");
		}
		try {
			com.ecomm.dbentity.User dbuser = userDaoServices.listUserByMailId(email);
			if (dbuser == null) {
				throw new EcommWebException(404, "User with email: "+email+" was not found");
			}
			com.ecomm.wsentity.User wsuser = UserMapper.mapDbToWs(dbuser);
			return EcommResponse.getResponseOk(wsuser);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listUserByMobileNumber(String mobileNumber) {
		if (mobileNumber == null) {
			throw new EcommWebException(404, "Not found any user with mobile no. = null");
		}
		try {
			com.ecomm.dbentity.User dbuser = userDaoServices.listUserByMobileNumber(Integer.parseInt(mobileNumber));
			if (dbuser == null) {
				throw new EcommWebException(404, "User with mobile no.: "+mobileNumber+" was not found");
			}
			com.ecomm.wsentity.User wsuser = UserMapper.mapDbToWs(dbuser);
			return EcommResponse.getResponseOk(wsuser);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

}
