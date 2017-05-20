package com.ecomm.ws.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.ProductDAO;
import com.ecomm.db.services.ProductDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.wsentity.Product;
import com.ecomm.wsentity.Products;


public class ProductServicesImpl implements ProductServices {

	private ProductDaoServicesImpl productDaoServices;
	
	private String dozerMappingFilePath = "dozer-bean-mapping.xml";

	public void setProductDaoServices(ProductDaoServicesImpl productDaoServices) {
		this.productDaoServices = productDaoServices;
	}

	private com.ecomm.dbentity.Product mapWsToDb(com.ecomm.wsentity.Product wsproduct) {
		com.ecomm.dbentity.Product dbproduct = new com.ecomm.dbentity.Product();
		List<String> list = new ArrayList();
		list.add(dozerMappingFilePath);
		Mapper mapper = new DozerBeanMapper(list);
		mapper.map(wsproduct, dbproduct, "product_mapping");
		return dbproduct;
	}

	private com.ecomm.wsentity.Product mapDbToWs(com.ecomm.dbentity.Product dbproduct) {
		com.ecomm.wsentity.Product wsproduct = new com.ecomm.wsentity.Product();
		List<String> list = new ArrayList<String>();
		list.add(dozerMappingFilePath);
		Mapper mapper = new DozerBeanMapper(list);
		mapper.map(dbproduct, wsproduct, "product_mapping");
		return wsproduct;
	}

	public Response listAllProducts() {
		try{ 
			List<com.ecomm.dbentity.Product> dbproductList = productDaoServices.listAllProducts();
			EcommLogger.info("FROM DAO: "+dbproductList);
			Products wsproducts = new Products();
			if(dbproductList!=null && !dbproductList.isEmpty()){
				for (com.ecomm.dbentity.Product dbproduct : dbproductList) {
					wsproducts.addProduct(mapDbToWs(dbproduct));
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
			com.ecomm.wsentity.Product wsproduct = mapDbToWs(dbproduct);
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
			com.ecomm.dbentity.Product dbproduct = productDaoServices.addProduct(mapWsToDb(wsproduct));
			com.ecomm.wsentity.Product wsCreatedProduct = mapDbToWs(dbproduct);
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
			com.ecomm.dbentity.Product dbproduct = productDaoServices.updateProduct(mapWsToDb(wsproduct));
			return EcommResponse.getResponseUpdated(mapDbToWs(dbproduct), uriInfo);
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
			productDaoServices.deleteProduct(mapWsToDb(wsproduct));
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

}
