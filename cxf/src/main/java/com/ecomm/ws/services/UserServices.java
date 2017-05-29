package com.ecomm.ws.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ecomm.ws.servicelines.ServicePaths;
import com.ecomm.wsentity.Product;
import com.ecomm.wsentity.User;
import com.ecomm.wsentity.Users;


@Path(ServicePaths.USER_SERVICE_BASE_URI)
public interface UserServices {

	/**
	 * ******************************************************************************************
	 * PRIMARY SERVICES: Comprises of Simple CRUD database services. 
	 * 		These are all mostly single step services and extensively used in admin operations 
	 * ******************************************************************************************
	 * SECONDARY SERVICES: Built on the top of the primary database services.
	 * 		These are customized services and internally will call the primary webservices.
	 * 		In some cases new customized DB statements are used to improve performance.
	 * ****************************************************************************************** 
	 */
	
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
	
	@POST
	@Path(ServicePaths.ADD_USER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addUser(User user, @Context UriInfo uriInfo);
	
	@PUT
	@Path(ServicePaths.UPDATE_USER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateUser(User wsuser, @Context UriInfo uriInfo);

}
