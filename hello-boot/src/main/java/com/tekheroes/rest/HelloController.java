package com.tekheroes.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// URL: http://localhost:8880/hello
	@GetMapping(value = "/hello")
	public String sayHello() {
		return "Get: Hello Spring Boot";
	}
	
	@PostMapping(value = "/hello")
	public String sayPostHello() {
		return "Post: Hello Spring Boot";
	}
	
	@PutMapping(value = "/hello")
	public String sayPutHello() {
		return "Put: Hello Spring Boot";
	}
	
	@DeleteMapping(value = "/hello")
	public String sayDeleteHello() {
		return "Delete: Hello Spring Boot";
	}
}
