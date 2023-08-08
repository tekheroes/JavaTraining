package com.tekheroes.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tekheroes.dao.CustomerDao;
import com.tekheroes.entity.Customer;

public class TestCustomerDao {
	private static CustomerDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new CustomerDao();
	}
	
	@Test
	public void testSave() {
		Customer c = new Customer(121, "Frank", 1200);
		dao.save(c);
	}
	
	@Test
	public void testFetch() {
		Customer c = dao.fetch(121);
		assertNotNull(c);
		System.out.println(c);
	}
	
	@Test
	public void testList() {
		List<Customer> customers = dao.list();
		assertEquals(3, customers.size());
		customers.forEach(System.out::println);
	}
	
	@Test
	public void testDelete() {
		
	}
}
