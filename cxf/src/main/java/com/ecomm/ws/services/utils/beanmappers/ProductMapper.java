package com.ecomm.ws.services.utils.beanmappers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dbentity.Product;
import com.ecomm.dbentity.ProductImageUrls;
import com.ecomm.dbentity.ProductSpecification;


public class ProductMapper {

	private static final String MAP_ID = "product_mapping"; 
	
	public static com.ecomm.dbentity.Product mapWsToDb(com.ecomm.wsentity.Product wsproduct) {
		com.ecomm.dbentity.Product dbproduct = new com.ecomm.dbentity.Product();
		DozerMapper.getBeanMapper().map(wsproduct, dbproduct, ProductMapper.MAP_ID);
		dbproduct.setProductSpecifications(ProductMapper.getWsProductSpecificationsToDb(wsproduct));
		dbproduct.setProductImageUrls(ProductMapper.getWsProductImageUrlsToDb(wsproduct));
		return dbproduct;
	}

	public static com.ecomm.wsentity.Product mapDbToWs(com.ecomm.dbentity.Product dbproduct) {
		com.ecomm.wsentity.Product wsproduct = new com.ecomm.wsentity.Product();
		DozerMapper.getBeanMapper().map(dbproduct, wsproduct, ProductMapper.MAP_ID);
		wsproduct.setProductSpecifications(ProductMapper.getDbProductSpecificationsToWs(dbproduct));
		return wsproduct;
	}


	// get Set<ProductImageUrls@Object> for dbproducts
	private static Set getWsProductImageUrlsToDb(com.ecomm.wsentity.Product wsproduct) {
		Set<String> imageUrls = wsproduct.getProductImageUrls();
		Set<ProductImageUrls> imageUrlObjects = new HashSet<ProductImageUrls>();
		for(String url : imageUrls){
			imageUrlObjects.add(new ProductImageUrls(url));
		}
		return imageUrlObjects;
	}
	
	// get Map<p, ProductSpecification@Object> for dbproducts
	private static Map getWsProductSpecificationsToDb(com.ecomm.wsentity.Product wsproduct) {
		Map<String, ProductSpecification> dbproductSpecifications = new HashMap<String, ProductSpecification>();
		EcommLogger.info("WEB SERVICE PRODUCT SPECTIFICATION = "+wsproduct.getProductSpecifications());
		Map ps = wsproduct.getProductSpecifications();
		Set<String> properties = ps.keySet();
		for(String property : properties){
			ProductSpecification productSpecification = new ProductSpecification();
			productSpecification.setValue((String)ps.get(property));
			EcommLogger.info("Setting value = "+(String)ps.get(property));
			dbproductSpecifications.put(property, productSpecification);
		}
		EcommLogger.info("DB ENCODED PRODUCTS = "+dbproductSpecifications);
		return dbproductSpecifications;
	}
	
	// get Map<p, v> for wsproduct
	public static Map<String, String> getDbProductSpecificationsToWs(Product dbproduct){
		Map<String, String> wsproductSpecifications = new HashMap<String, String>();
		Map productSpecifications = dbproduct.getProductSpecifications();
		Set<String> properties = productSpecifications.keySet();
		for(String property : properties){
			wsproductSpecifications.put(property, 
					((ProductSpecification)productSpecifications.get(property)).getValue());
		}
		return wsproductSpecifications;
	}
}
