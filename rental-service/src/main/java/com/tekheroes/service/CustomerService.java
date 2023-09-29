package com.tekheroes.service;

import java.util.List;

import com.tekheroes.entity.Customer;

public interface CustomerService {

	void add(Customer c);
	
	Customer find(int custId);
	
	List<Customer> list();
	
	Customer authenticate(String phone, String password);
}
