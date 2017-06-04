package com.ecomm.wsentity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {

    @XmlElement(name="product")
    private List<Product> productList; 

    public Products(){
    	this.productList = new ArrayList<Product>();
    }
    
    public Products(List<Product> productList){
    	this.productList = productList;
    }

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productItems) {
		this.productList = productItems;
	}
	
	public void addProduct(Product product) {
		this.productList.add(product);
	}
}
