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
	public Product updateProduct(Product product, @Context UriInfo uriInfo);
	
	@POST
	public Product addOrUpdateProduct(Product product, @Context UriInfo uriInfo);
	
	@DELETE
	public void deleteProduct(Product product, @Context UriInfo uriInfo);
	
	@DELETE
	public void deleteProductById(String id, @Context UriInfo uriInfo);

}
