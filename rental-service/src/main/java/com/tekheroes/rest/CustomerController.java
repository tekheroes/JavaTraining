package com.tekheroes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tekheroes.entity.Customer;
import com.tekheroes.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String add(@RequestBody Customer c) {
		service.add(c);
		return "Customer added!!";
	}
	
	@GetMapping(value = "/{cid}", produces = "application/json")
	public Customer find(@PathVariable("cid") int custId) {
		return service.find(custId);
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	public List<Customer> list() {
		return service.list();
	}
	
	@GetMapping(value = "/auth", produces = "application/json")
	public Customer authenticate(@RequestParam String phone, @RequestParam String password) {
		return service.authenticate(phone, password);
	}
}
