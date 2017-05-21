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
import com.ecomm.ws.servicelines.ServiceProperties;
import com.ecomm.wsentity.Product;
import com.ecomm.wsentity.Products;


@Path(ServicePaths.PRODUCT_SERVICE_BASE_URI)
public interface ProductServices {

	// Unit operation
	@GET
	@Path(ServicePaths.LIST_ALL_PRODUCTS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listAllProducts();
	
	@GET
	@Path(ServicePaths.LIST_PRODUCT_BY_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listProductsById(@PathParam("id") String id);
	
	
	@POST
	@Path(ServicePaths.ADD_PRODUCT)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response addProduct(Product product, @Context UriInfo uriInfo);
	
	@PUT
	@Path(ServicePaths.UPDATE_PRODUCT)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response updateProduct(Product product, @Context UriInfo uriInfo);
		
	@DELETE
	@Path(ServicePaths.DELETE_PRODUCT)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteProduct(Product product);
	
	@DELETE
	@Path(ServicePaths.DELETE_PRODUCT_BY_ID)
	public Response deleteProductById(@PathParam("id") String id);

	
	// Bulk operations
	
	@DELETE
	@Path(ServicePaths.DELETE_ALL_PRODUCTS)
	public Response deleteAllProducts();
/*	
	@POST
	@Path("/products/list")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response addProducts(Products products);
*/
}
