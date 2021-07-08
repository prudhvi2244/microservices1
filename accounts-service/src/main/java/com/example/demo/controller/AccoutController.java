package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccoutController {

	@GetMapping(value = "/createAccount")
	public String createAccount()
	{
		return "Account Created";
	}
	
}
