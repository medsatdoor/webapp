package com.ecomm.ws.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ecomm.exception.EcommException;
import com.ecomm.wsentity.Product;


@Path("/product-services")
public interface ProductServices {

	@GET
    @Path("/products")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> listAllProducts();
	
	@GET
    @Path("/products/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Product listProductsById(@PathParam("id") String id) throws EcommException;
	
}
