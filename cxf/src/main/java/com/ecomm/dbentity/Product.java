package com.ecomm.dbentity;

import java.util.Date;
import java.util.Map;

public class Product {
	
	private String id;
	private String name;
	private String type;
	private String subtype;
	private float price;
	private String company;
	private float discount;
	private float rating;
	private int warranty;
	private int stock;
	private Date deliveryTime;
	private String color;
	private int packOf;
	private String material;
	private Map productSpecifications;

	public Product() {
		// Required for serialization
	}

	// constructor with not null fields of database
	public Product(String name, String type, String subtype, float price, Date deliveryTime, int stock) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.subtype = subtype;
		this.price = price;
		this.stock = stock;
		this.deliveryTime = deliveryTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPackOf() {
		return packOf;
	}

	public void setPackOf(int packOf) {
		this.packOf = packOf;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Map getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(Map productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

}
