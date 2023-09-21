package com.tekheroes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tekheroes.entity.Flight;
import com.tekheroes.service.FlightService;

@CrossOrigin
@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService service;
	
	// http://localhost:8880/flight/add
	@PostMapping(value = "/add", consumes = "application/json")
	public void add(@RequestBody Flight f) {
		service.save(f);
	}
	
	// http://localhost:8880/flight/all
	@GetMapping(value = "/all", produces = "application/json")
	public List<Flight> list() {
		return service.list();
	}
	
	// http://localhost:8880/flight/123
	@GetMapping(value = "/{code}", produces = "application/json")
	public Flight find(@PathVariable int code) {
		return service.fetch(code);
	}
	
	// http://localhost:8880/flight/carrier/Jet
	@GetMapping(value = "/carrier/{carrier}", produces = "application/json")
	public List<Flight> byCarrier(@PathVariable String carrier) {
		return service.byCarrier(carrier);
	}
	
	// http://localhost:8880/flight/route?source=JFK&destination=Florida
	@GetMapping(value = "/route", produces = "application/json")
	public List<Flight> byRoute(@RequestParam String source, @RequestParam String destination) {
		return service.byRoute(source, destination);
	}
	
	// http://localhost:8880/flight/123
	@DeleteMapping(value = "/{code}")
	public void remove(@PathVariable int code) {
		this.service.remove(code);
	}
}
