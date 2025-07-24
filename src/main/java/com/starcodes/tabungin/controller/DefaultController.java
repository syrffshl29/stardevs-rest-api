package com.starcodes.tabungin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {
	@GetMapping
	public String getData(){
		System.out.println("Star Devs");
		return "Hello from Star Devs!";
	}
}

