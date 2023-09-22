package com.ey.service;

import java.util.List;

import com.ey.dto.ProductDto;
import com.ey.entity.Product;
import com.ey.exception.InvalidProductException;

public interface ProductService {

	void save(ProductDto p) throws InvalidProductException;
	
	List<Product> list();
	
	Product getByCode(int code) throws InvalidProductException;
	
	void delete(int code) throws InvalidProductException;
	
	List<Product> listByCategory(String cat);
	
	List<Product> listByPriceRange(double min, double max);
	
	List<Product> listByPriceLowToHigh();
}
