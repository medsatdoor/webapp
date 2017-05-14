package com.ecomm.ws.services;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.ProductDAO;
import com.ecomm.db.services.ProductDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.wsentity.Product;


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

	public List<com.ecomm.wsentity.Product> listAllProducts() {
		try{ 
			EcommLogger.info("create product service posted...");
			List<com.ecomm.dbentity.Product> dbproductList = productDaoServices.listAllProducts();
			EcommLogger.info("FROM DAO: "+dbproductList);
			List<com.ecomm.wsentity.Product> wsproductList = new ArrayList<Product>();
			if(dbproductList!=null && !dbproductList.isEmpty()){
				for (com.ecomm.dbentity.Product dbproduct : dbproductList) {
					wsproductList.add(mapDbToWs(dbproduct));
				}
			}	
			return wsproductList;
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public com.ecomm.wsentity.Product listProductsById(final String id) {
		try {
			if (id == null) {
				throw new EcommWebException(404, "Product id = null");
			}
			com.ecomm.dbentity.Product dbproduct = productDaoServices.listProductsById(id);
			if (dbproduct == null) {
				throw new EcommWebException(404, "Product id: "+id+" was not found");
			}
			com.ecomm.wsentity.Product wsproduct = new Product();
			wsproduct = mapDbToWs(dbproduct);
			return wsproduct;
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

}
