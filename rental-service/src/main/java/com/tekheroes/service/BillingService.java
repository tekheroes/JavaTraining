package com.tekheroes.service;

import java.util.List;

import com.tekheroes.entity.Invoice;
import com.tekheroes.vo.BillingVO;

public interface BillingService {

	int rentCar(BillingVO vo);
	
	void returnCar(int id);
	
	List<Invoice> listByCustomer(int custId);
	
	List<Invoice> listByVehicle(String regNo);
}
