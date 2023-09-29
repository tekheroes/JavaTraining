package com.tekheroes.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekheroes.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByPhoneAndPassword(String phone, String password);
}
