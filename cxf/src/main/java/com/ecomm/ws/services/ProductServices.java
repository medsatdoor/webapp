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

import org.springframework.transaction.annotation.Transactional;

import com.ecomm.exception.EcommException;
import com.ecomm.wsentity.Product;


@Path("/product-services")
public interface ProductServices {

	@GET
    @Path("/products")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listAllProducts();
	
	@GET
    @Path("/products/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listProductsById(@PathParam("id") String id);
	
	
	@POST
	@Path("/products/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response addProduct(Product product, @Context UriInfo uriInfo);
	
	@PUT
	@Path("/products/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response updateProduct(Product product, @Context UriInfo uriInfo);
		
	@DELETE
	@Path("/products/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteProduct(Product product);
	
	@DELETE
	@Path("/products/{id}")
	public Response deleteProductById(@PathParam("id") String id);

	@DELETE
	@Path("/products/all")
	public Response deleteAllProducts();
}
