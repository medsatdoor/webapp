package com.ecomm.dbentity;

public class ProductImageUrls {

	private int imageId;
	
	private String productImageUrl;
	
	public ProductImageUrls(){
		// Constructor for hibernate serialization
	}
	
	public ProductImageUrls(String productImageUrl){
		this.productImageUrl = productImageUrl;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	@Override
	public String toString() {
		return this.productImageUrl;
	}
}
