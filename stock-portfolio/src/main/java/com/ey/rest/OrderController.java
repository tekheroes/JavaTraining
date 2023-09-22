package com.ey.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.entity.Order;
import com.ey.service.OrderService;
import com.ey.vo.Input;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping(value = "/buy", consumes = "application/json")
	public String buyStock(@RequestBody Input in) {
		service.buyStock(in);
		return "Order placed successfully";
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public Order findOrder(@PathVariable("id") int oid) {
		return null;
	}
}
