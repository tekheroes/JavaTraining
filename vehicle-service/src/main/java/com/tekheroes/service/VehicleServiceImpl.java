package com.tekheroes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekheroes.entity.Vehicle;
import com.tekheroes.repo.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository repo;
	
	@Override
	public void add(Vehicle v) {
		repo.save(v);
	}

	@Override
	public Vehicle find(String regNo) {
		return repo.findById(regNo).get();
	}

	@Override
	public List<Vehicle> list() {
		return repo.findAll();
	}

	@Override
	public List<Vehicle> listAvailable() {
		return repo.findByAvailable();
	}

	@Override
	public void remove(String regNo) {
		repo.deleteById(regNo);
	}

	@Override
	public void makeAvailable(Vehicle v) {
		repo.save(v);
	}
}
