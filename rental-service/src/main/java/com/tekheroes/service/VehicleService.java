package com.tekheroes.service;

import java.util.List;

import com.tekheroes.entity.Vehicle;

public interface VehicleService {

	void add(Vehicle v);
	
	Vehicle find(String regNo);
	
	List<Vehicle> list();
	
	List<Vehicle> listAvailable();
	
	void remove(String regNo);
}
