package com.ecomm.ws.services;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Session;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.db.services.UserDaoServicesImpl;
import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.services.utils.beanmappers.ProductMapper;
import com.ecomm.ws.services.utils.beanmappers.UserMapper;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.wsentity.User;
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


	public Response addUser(User wsuser, UriInfo uriInfo) {
		validateUserData(wsuser);
		try{
			com.ecomm.dbentity.User dbuser = userDaoServices.addUser(UserMapper.mapWsToDb(wsuser));
			com.ecomm.wsentity.User wsCreatedUser = UserMapper.mapDbToWs(dbuser);
			return EcommResponse.getResponseCreated(wsCreatedUser, uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	private void validateUserData(com.ecomm.wsentity.User wsuser){
		if(wsuser.getUserId() != null){
			throw new EcommWebException(400, "INVALID USER ID: is system generated should be null");
		}
		if(wsuser.getName() == null || wsuser.getName().isEmpty()){
			throw new EcommWebException(400, "INALID DATA: Please provide valid user name");
		}
		String reqEmailAddress = wsuser.getEmailAddress();
		if(reqEmailAddress == null || reqEmailAddress.isEmpty() || !reqEmailAddress.contains("@") 
				|| !reqEmailAddress.contains(".") || reqEmailAddress.indexOf("@")>reqEmailAddress.lastIndexOf(".")){
			throw new EcommWebException(400, "INALID DATA: Please provide valid email address");
		}
		String mno = String.valueOf(wsuser.getMobileNumber()).trim();
		if(mno.length() != 10 && mno.length() != 12){
			throw new EcommWebException(400, "INALID DATA: Please provide valid mobile number");
		}
		String passwd = wsuser.getPassword();
		if(passwd==null || passwd.isEmpty()){
			throw new EcommWebException(400, "INALID DATA: Please provide valid password (cannot be null or empty) ");
		}
		if(passwd.length() < 6){
			throw new EcommWebException(400, "INALID DATA: min. password length should be 6");
		}
	}

	
	public Response updateUser(User wsuser, UriInfo uriInfo) {
		if (wsuser.getUserId() == null) {
			throw new EcommWebException(400, "INVALID USER ID = null");
		}
		try{
			com.ecomm.dbentity.User dbuser = userDaoServices.updateUser(UserMapper.mapWsToDb(wsuser));
			return EcommResponse.getResponseUpdated(UserMapper.mapDbToWs(dbuser), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

}


