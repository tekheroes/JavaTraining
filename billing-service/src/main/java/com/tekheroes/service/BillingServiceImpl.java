package com.tekheroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tekheroes.entity.Invoice;
import com.tekheroes.repo.InvoiceRepository;
import com.tekheroes.vo.Billing;
import com.tekheroes.vo.Vehicle;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private InvoiceRepository repo;
	
	@Autowired
	private RestTemplate rest;
	
	@Override
	public int rentCar(Billing vo) {
		Invoice invoice = new Invoice();
		invoice.setHireDate(vo.getHireDate());
		invoice.setDays(vo.getDays());
		invoice.setTotal(vo.getTotal());
		invoice.setReturned(false);
		invoice.setCustId(vo.getCustId());
		invoice.setRegNo(vo.getRegNo());
		Vehicle veh = rest.getForObject("http://VEHICLE-SERVICE/vehicle/" + vo.getRegNo(), Vehicle.class);
		veh.setAvailable(false);
		rest.put("http://VEHICLE-SERVICE/vehicle/update", veh);
		return repo.save(invoice).getId();
	}

	@Override
	public void returnCar(int id) {
		Invoice invoice = repo.findById(id).get();
		invoice.setReturned(true);
		repo.save(invoice);
		Vehicle veh = rest.getForObject("http://VEHICLE-SERVICE/vehicle/" + invoice.getRegNo(), Vehicle.class);
		veh.setAvailable(true);
		rest.put("http://VEHICLE-SERVICE/vehicle/update", veh);
	}

	@Override
	public List<Invoice> listByCustomer(int custId) {
		return repo.findByCustId(custId);
	}

	@Override
	public List<Invoice> listByVehicle(String regNo) {
		return repo.findByRegNo(regNo);
	}
}
