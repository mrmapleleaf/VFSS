package com.example.VFSS.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subscription")
public class SubscriptionIndexController {
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/index")
	public String goToIndex(Model model) {
			
			return "index";
	}
}