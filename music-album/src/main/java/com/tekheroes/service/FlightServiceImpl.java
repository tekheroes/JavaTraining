package com.tekheroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekheroes.entity.Flight;
import com.tekheroes.repo.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository repo;
	
	@Override
	public int save(Flight f) {
		repo.save(f);
		return f.getCode();
	}

	@Override
	public Flight fetch(int code) {
		return repo.findById(code).get();
	}

	@Override
	public List<Flight> list() {
		return repo.findAll();
	}

	@Override
	public List<Flight> byCarrier(String carrier) {
		return repo.findByCarrier(carrier);
	}

	@Override
	public List<Flight> byRoute(String source, String destiny) {
		return repo.findByRoute(source, destiny);
	}
}
