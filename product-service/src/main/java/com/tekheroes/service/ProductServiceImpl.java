package com.tekheroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekheroes.model.Product;
import com.tekheroes.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product persist(Product p) {
		return repo.save(p);
	}

	@Override
	public Product find(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public List<Product> listByCategory(String category) {
		return repo.findByCategory(category);
	}

	@Override
	public boolean remove(int id) {
		repo.deleteById(id);
		return true;
	}

}
