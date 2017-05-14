package com.ecomm.db.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ecomm.dbentity.Product;
import com.ecomm.exception.EcommException;


public interface ProductDaoServices {

	@Transactional
    public List<Product> listAllProducts() throws EcommException;
	
    @Transactional
    public Product listProductsById(String id) throws EcommException;
	
}
