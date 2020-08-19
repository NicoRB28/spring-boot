package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String homer() {
		
		//return "redirect:/app/index";
		return "forward:/app/index";
	}

}
