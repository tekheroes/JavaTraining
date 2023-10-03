package com.tekheroes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekheroes.entity.Vehicle;
import com.tekheroes.service.VehicleService;

@CrossOrigin
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService service;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public String add(@RequestBody Vehicle v) {
		service.add(v);
		return "Vehicle added!!";
	}
	
	@GetMapping(value = "/{reg}", produces = "application/json")
	public Vehicle find(@PathVariable String reg) {
		return service.find(reg);
	}
	
	@GetMapping(value = "/all", produces = "application/json")
	public List<Vehicle> list() {
		return service.list();
	}
	
	@GetMapping(value = "/available", produces = "application/json")
	public List<Vehicle> listAvailable() {
		return service.listAvailable();
	}
	
	@PutMapping(value = "/update", consumes = "application/json")
	public void setAvailable(@RequestBody Vehicle v) {
		service.makeAvailable(v);
	}
	
	@DeleteMapping(value = "/{reg}")
	public String remove(@PathVariable String reg) {
		service.remove(reg);
		return "Vehicle deleted!";
	}
}
