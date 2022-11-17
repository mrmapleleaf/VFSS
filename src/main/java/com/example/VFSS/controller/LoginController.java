package com.example.VFSS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.VFSS.service.UserService;
import com.example.VFSS.service.UserServiceImpl;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private final UserService userService;
	
	public LoginController(UserServiceImpl userServiceImpl) {
		this.userService = userServiceImpl;
	}

	@GetMapping()
	public String goToLogin() {
		
		return "login/login";
	}
}
