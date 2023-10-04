package com.tekheroes.service;

import java.util.List;

import com.tekheroes.model.Product;

public interface ProductService {

	Product persist(Product p);
	
	Product find(int id);
	
	List<Product> list();
	
	List<Product> listByCategory(String category);
	
	boolean remove(int id);
}
