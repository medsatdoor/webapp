package com.ecomm.ws.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.ecomm.exception.EcommException;
import com.ecomm.ws.servicelines.ServicePaths;
import com.ecomm.wsentity.Plan;
import com.ecomm.wsentity.Plans;
import com.ecomm.wsentity.Product;
import com.ecomm.wsentity.Products;


@Path(ServicePaths.PLAN_SERVICE_BASE_URI)
public interface PlanServices {

	// Unit operation
	@GET
	@Path(ServicePaths.LIST_ALL_PLANS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listAllPlans();
	
	@GET
	@Path(ServicePaths.LIST_PLAN_BY_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listPlanById(@PathParam("planId") String id);
	
	
	@POST
	@Path(ServicePaths.ADD_PLAN)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addPlan(Plan plan, @Context UriInfo uriInfo);
	
	@PUT
	@Path(ServicePaths.UPDATE_PLAN)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response updatePlan(Plan plan, @Context UriInfo uriInfo);
		
	@DELETE
	@Path(ServicePaths.DELETE_PLAN)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deletePlan(Plan plan);
	
	@DELETE
	@Path(ServicePaths.DELETE_PLAN_BY_ID)
	public Response deletePlanById(@PathParam("planId") String planId);

	
	// Bulk operations
	
	@DELETE
	@Path(ServicePaths.DELETE_ALL_PLANS)
	public Response deleteAllPlans();

	@POST
	@Path(ServicePaths.ADD_PLANS)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addPlans(Plans plans);

}

