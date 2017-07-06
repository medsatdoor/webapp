package com.ecomm.dbentity;

public class ProductSpecification {

	private int productSpecificationId;
	
	private String value;
	
	public ProductSpecification(){
		// Constructor for hibernate serialization
	}

	public ProductSpecification(String value){
		this.value = value;
	}
	
	public int getProductSpecificationId() {
		return productSpecificationId;
	}

	public void setProductSpecificationId(int productSpecificationId) {
		this.productSpecificationId = productSpecificationId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
