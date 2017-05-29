package com.ecomm.ws.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ecomm.ws.servicelines.ServicePaths;

@Path(ServicePaths.USER_SERVICE_BASE_URI)
public interface UserServices {

	@GET
	@Path(ServicePaths.LIST_ALL_USERS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listAllUsers();
	
	@GET
	@Path(ServicePaths.LIST_USER_BY_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listUsersbyId(@PathParam("userId") String userId);
	
	@GET
	@Path(ServicePaths.LIST_USER_BY_EMAIL)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listUserByEmail(@PathParam("email") String email);
	
	@GET
	@Path(ServicePaths.LIST_USER_BY_MOBILE_NO)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listUserByMobileNumber(@PathParam("mobileNo") String mobileNumber);
	
}
