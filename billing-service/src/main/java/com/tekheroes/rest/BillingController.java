package com.tekheroes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekheroes.entity.Invoice;
import com.tekheroes.service.BillingService;
import com.tekheroes.vo.Billing;

@CrossOrigin
@RestController
@RequestMapping("/invoice")
public class BillingController {

	@Autowired
	private BillingService service;
	
	@PostMapping(value = "/rent", consumes = "application/json")
	public String rentCar(@RequestBody Billing vo) {
		int id = service.rentCar(vo);
		return "Car booking done with Inovice No: " + id;
	}
	
	@PostMapping(value = "/return/{id}")
	public String returnCar(@PathVariable int id) {
		service.returnCar(id);
		return "Car returned for Invoice No: " + id;
	}
	
	@GetMapping(value = "/customer/{cid}", produces = "application/json")
	public List<Invoice> byCustomer(@PathVariable int cid) {
		return service.listByCustomer(cid);
	}
	
	@GetMapping(value = "/vehicle/{reg}", produces = "application/json")
	public List<Invoice> byVehicle(@PathVariable String reg) {
		return service.listByVehicle(reg);
	}
}
