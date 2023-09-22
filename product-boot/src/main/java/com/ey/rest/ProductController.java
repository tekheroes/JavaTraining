package com.ey.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ey.dto.ProductDto;
import com.ey.entity.Product;
import com.ey.exception.InvalidProductException;
import com.ey.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	// URL: http://localhost:8880/product/add
	@PostMapping(value = "/add", consumes = "application/json")
	public String add(@RequestBody @Valid ProductDto p) {
		try {
			service.save(p);
			return "Product added.";
		} catch (InvalidProductException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		}
	}

	// URL: http://localhost:8880/product/list
	@GetMapping(value = "/list", produces = "application/json")
	public List<Product> list() {
		return service.list();
	}
	
	// URL: http://localhost:8880/product/123
	@GetMapping(value = "/{code}")
	public Product find(@PathVariable int code) {
		try {
			return service.getByCode(code);
		} catch (InvalidProductException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	// URL: http://localhost:8880/product/123
	@DeleteMapping(value = "/{code}")
	public String remove(@PathVariable int code) {
		try {
			service.delete(code);
			return "Product deleted.";
		} catch (InvalidProductException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	// URL: http://localhost:8880/product/Mobile
	@GetMapping(value = "/{cat}", produces = "application/json")
	public List<Product> byCategory(@PathVariable("cat") String category) {
		return service.listByCategory(category);
	}
	
	// URL: http://localhost:8880/product/price?min=1000&max=5000
	@GetMapping(value = "/price", produces = "application/json")
	public List<Product> byPriceRange(@RequestParam double min, @RequestParam double max) {
		return service.listByPriceRange(min, max);
	}
	
	// URL: http://localhost:8880/product/low2high
	@GetMapping(value = "/low2high", produces = "application/json")
	public List<Product> byPriceDesc() {
		return service.listByPriceLowToHigh();
	}
}
