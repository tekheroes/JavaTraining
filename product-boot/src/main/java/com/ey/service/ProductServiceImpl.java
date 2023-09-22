package com.ey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.dto.ProductDto;
import com.ey.entity.Product;
import com.ey.exception.InvalidProductException;
import com.ey.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public void save(ProductDto p) throws InvalidProductException {
		if(repo.findById(p.getCode()).isPresent())
			throw new InvalidProductException("Product already exist with code: " + p.getCode());
		
		Product prod = new Product();
		prod.setCode(p.getCode());
		prod.setName(p.getName());
		prod.setCategory(p.getCategory());
		prod.setPrice(p.getPrice());
		repo.save(prod);
	}

	@Override
	public List<Product> list() {
		return repo.findAll();
	}

	@Override
	public Product getByCode(int code) throws InvalidProductException {
		return repo.findById(code)
				.orElseThrow(() -> new InvalidProductException("Product does not exist with code: " + code));
	}

	@Override
	public void delete(int code) throws InvalidProductException {
		getByCode(code);
		repo.deleteById(code);
	}

	@Override
	public List<Product> listByCategory(String cat) {
		return repo.findByCategory(cat);
	}

	@Override
	public List<Product> listByPriceRange(double min, double max) {
		return repo.findByPriceRange(min, max);
	}

	@Override
	public List<Product> listByPriceLowToHigh() {
		return repo.findByPriceDesc();
	}
}
