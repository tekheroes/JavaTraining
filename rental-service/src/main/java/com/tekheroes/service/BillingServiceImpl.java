package com.tekheroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekheroes.entity.Customer;
import com.tekheroes.entity.Invoice;
import com.tekheroes.entity.Vehicle;
import com.tekheroes.repo.InvoiceRepository;
import com.tekheroes.vo.BillingVO;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private InvoiceRepository repo;
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Override
	public int rentCar(BillingVO vo) {
		Customer cust = custService.find(vo.getCustId());
		Vehicle veh = vehicleService.find(vo.getRegNo());
		
		Invoice invoice = new Invoice();
		invoice.setHireDate(vo.getHireDate());
		invoice.setDays(vo.getDays());
		invoice.setTotal(vo.getDays() * veh.getRate());
		invoice.setReturned(false);
		veh.setAvailable(false);
		invoice.setCustomer(cust);
		invoice.setVehicle(veh);
		
		return repo.save(invoice).getId();
	}

	@Override
	public void returnCar(int id) {
		Invoice invoice = repo.findById(id).get();
		invoice.setReturned(true);
		Vehicle veh = invoice.getVehicle();
		veh.setAvailable(true);
		vehicleService.add(veh);
	}

	@Override
	public List<Invoice> listByCustomer(int custId) {
		return repo.findByCustomerCustId(custId);
	}

	@Override
	public List<Invoice> listByVehicle(String regNo) {
		return repo.findByVehicleRegNo(regNo);
	}
}
