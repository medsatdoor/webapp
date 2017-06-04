package com.ecomm.ws.services.utils.beanmappers;

public class ProductMapper {

	private static final String MAP_ID = "product_mapping"; 
	
	public static com.ecomm.dbentity.Product mapWsToDb(com.ecomm.wsentity.Product wsproduct) {
		com.ecomm.dbentity.Product dbproduct = new com.ecomm.dbentity.Product();
		DozerMapper.getBeanMapper().map(wsproduct, dbproduct, ProductMapper.MAP_ID);
		return dbproduct;
	}

	public static com.ecomm.wsentity.Product mapDbToWs(com.ecomm.dbentity.Product dbproduct) {
		com.ecomm.wsentity.Product wsproduct = new com.ecomm.wsentity.Product();
		DozerMapper.getBeanMapper().map(dbproduct, wsproduct, ProductMapper.MAP_ID);
		return wsproduct;
	}
}
