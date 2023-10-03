package com.tekheroes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekheroes.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	List<Invoice> findByCustId(int custId);
	
	List<Invoice> findByRegNo(String regNo);
}
