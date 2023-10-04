package com.tekheroes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekheroes.model.Product;
import com.tekheroes.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public Product add(@RequestBody Product p) {
		return service.persist(p);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Product find(@PathVariable int id) {
		return service.find(id);
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	public List<Product> list() {
		return service.list();
	}
	
	@GetMapping(value = "/category/{cat}", produces = "application/json")
	public List<Product> listByCategory(@PathVariable String cat) {
		return service.listByCategory(cat);
	}
	
	@PutMapping(value = "/update", consumes = "application/json")
	public Product update(@RequestBody Product p) {
		return service.persist(p);
	}
	
	@DeleteMapping(value = "/{id}")
	public boolean remove(@PathVariable int id) {
		return service.remove(id);
	}
}
