package com.tekheroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekheroes.entity.Customer;
import com.tekheroes.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public void add(Customer c) {
		repo.save(c);
	}

	@Override
	public Customer find(int custId) {
		return repo.findById(custId).get();
	}

	@Override
	public List<Customer> list() {
		return repo.findAll();
	}
}
