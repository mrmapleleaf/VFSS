package com.example.VFSS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toppage")
public class TopPageContorller {
	
	@GetMapping
	public String goToTopPage() {
		return "toppage";
	}
}
