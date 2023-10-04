package com.tekheroes.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tekheroes.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
	
	List<Product> findByCategory(String category);
}
