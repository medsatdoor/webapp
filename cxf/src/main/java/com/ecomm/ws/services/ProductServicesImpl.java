package com.ecomm.ws.services;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dao.utils.HibernateProperties;
import com.ecomm.db.services.ProductDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.wsentity.Product;
import com.ecomm.wsentity.Products;
import com.ecomm.ws.services.utils.beanmappers.ProductMapper;


public class ProductServicesImpl implements ProductServices {

	private ProductDaoServicesImpl productDaoServices;
	
	public void setProductDaoServices(ProductDaoServicesImpl productDaoServices) {
		this.productDaoServices = productDaoServices;
	}

	public Response listAllProducts() {
		try{ 
			List<com.ecomm.dbentity.Product> dbproductList = productDaoServices.listAllProducts();
			EcommLogger.info("FROM DAO: "+dbproductList);
			Products wsproducts = new Products();
			if(dbproductList!=null && !dbproductList.isEmpty()){
				for (com.ecomm.dbentity.Product dbproduct : dbproductList) {
					wsproducts.addProduct(ProductMapper.mapDbToWs(dbproduct));
				}
			}	
			return EcommResponse.getResponseOk(wsproducts);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listProductsById(final String id) {
		if (id == null) {
			throw new EcommWebException(404, "Product id = null");
		}
		try {
			com.ecomm.dbentity.Product dbproduct = productDaoServices.listProductsById(id);
			if (dbproduct == null) {
				throw new EcommWebException(404, "Product id: "+id+" was not found");
			}
			com.ecomm.wsentity.Product wsproduct = ProductMapper.mapDbToWs(dbproduct);
			return EcommResponse.getResponseOk(wsproduct);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
	public Response addProduct(Product wsproduct, UriInfo uriInfo){
		if(wsproduct.getId() != null){
			throw new EcommWebException(400, "INVALID PRODUCT ID: is system generated should be null");
		}
		try{
			com.ecomm.dbentity.Product dbproduct = productDaoServices.addProduct(ProductMapper.mapWsToDb(wsproduct));
			com.ecomm.wsentity.Product wsCreatedProduct = ProductMapper.mapDbToWs(dbproduct);
			return EcommResponse.getResponseCreated(wsCreatedProduct, uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
	public Response updateProduct(Product wsproduct, UriInfo uriInfo){
		if (wsproduct.getId() == null) {
			throw new EcommWebException(400, "INVALID PRODUCT ID = null");
		}
		try{
			com.ecomm.dbentity.Product dbproduct = productDaoServices.updateProduct(ProductMapper.mapWsToDb(wsproduct));
			return EcommResponse.getResponseUpdated(ProductMapper.mapDbToWs(dbproduct), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
	public Response deleteProduct(Product wsproduct){
		if (wsproduct.getId() == null) {
			throw new EcommWebException(400, "INVALID PRODUCT ID = null");
		}
		try{	
			productDaoServices.deleteProduct(ProductMapper.mapWsToDb(wsproduct));
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
	public Response deleteProductById(String id){
		if (id == null) {
			throw new EcommWebException(400, "INVALID PRODUCT ID = null");
		}
		try{
			productDaoServices.deleteProductById(id);
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteAllProducts() {
		try{
			productDaoServices.deleteAllProducts();
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response addProducts(Products wsproducts) {
		try{
			List<com.ecomm.wsentity.Product> wsproductList = wsproducts.getProductList();
			List<com.ecomm.dbentity.Product> dbproductList = new ArrayList();
			for(com.ecomm.wsentity.Product wsproduct : wsproductList){
				dbproductList.add(ProductMapper.mapWsToDb(wsproduct));
			}
			productDaoServices.addProductList(dbproductList);
			return EcommResponse.getResponseOk();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

}
