package com.tekheroes.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping(value = "/login", produces = "text/html")
	public String authenticate(@RequestParam String username, @RequestParam String password) {
		if(username.equals("zubair") && password.equals("oracle"))
			return "<h1>Welcome, Login successful</h1>";
		else
			return "<h1>Invalid Username/Password</h1>";
	}
}

// Validate login based on fixed values
// On success return "Login Successful" on failure "Invalid Username/password" as HTML

