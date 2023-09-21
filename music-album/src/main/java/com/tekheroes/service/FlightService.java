package com.tekheroes.service;

import java.util.List;

import com.tekheroes.entity.Flight;

public interface FlightService {
	
	int save(Flight f);
	
	Flight fetch(int code);
	
	List<Flight> list();
	
	List<Flight> byCarrier(String carrier);
	
	List<Flight> byRoute(String source, String destiny);
	
	void remove(int code);
}
