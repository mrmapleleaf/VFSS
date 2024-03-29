package com.example.VFSS.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@Autowired
	HttpSession session;
	
	@GetMapping()
	public String logout() {
		session.invalidate();
		return "redirect:/toppage";
	}
}
