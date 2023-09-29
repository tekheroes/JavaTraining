package com.tekheroes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekheroes.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	List<Invoice> findByCustomerCustId(int custId);
	
	List<Invoice> findByVehicleRegNo(String regNo);
}
