package com.tekheroes.test;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tekheroes.dao.FlightDao;
import com.tekheroes.entity.Flight;

public class TestFlightDao {
	private static FlightDao dao;
	
	@BeforeAll
	public static void setup() {
		dao = new FlightDao();
	}
	
	@Test
	public void testSave() {
		Flight f = new Flight(112, "Indigo", "Kolkata", "Kochi");
		dao.save(f);
	}
	
	@Test
	public void testList() {
		List<Flight> flights = dao.list();
		flights.forEach(System.out::println);
	}
	
	@Test
	public void testListByCarrier() {
		List<Flight> flights = dao.listByCarrier("Jet");
		flights.forEach(System.out::println);
	}
	
	@Test
	public void testListByRoute() {
		List<Flight> flights = dao.listByRoute("Mumbai", "Goa");
		flights.forEach(System.out::println);
	}
	
	@Test
	public void testCount() {
		int count = dao.count();
		System.out.println("Total Flights: " + count);
	}
}
