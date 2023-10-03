package com.tekheroes.service;

import java.util.List;

import com.tekheroes.entity.Invoice;
import com.tekheroes.vo.Billing;

public interface BillingService {

	int rentCar(Billing vo);
	
	void returnCar(int id);
	
	List<Invoice> listByCustomer(int custId);
	
	List<Invoice> listByVehicle(String regNo);
}
