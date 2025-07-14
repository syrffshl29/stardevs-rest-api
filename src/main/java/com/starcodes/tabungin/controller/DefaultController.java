package com.starcodes.tabungin.controller;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/")
//public class DefaultController {
//	@GetMapping
//	public String getData(){
//		System.out.println("Star Devs");
//		return "Hello from Star Devs!";
//	}
//}

import org.springframework.stereotype.Controller; // Ganti @RestController menjadi @Controller
import org.springframework.ui.Model; // Import Model
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Ganti @RestController menjadi @Controller
@RequestMapping("/")
public class DefaultController {

	@GetMapping
	public String getData(Model model){
		System.out.println("Star Devs");
		model.addAttribute("message", "Hello from Star Devs!");
		model.addAttribute("label", "STAR Devs");
		return "greetings";
	}

}
