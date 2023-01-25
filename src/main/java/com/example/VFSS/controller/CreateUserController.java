package com.example.VFSS.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.VFSS.entity.User;
import com.example.VFSS.form.UserForm;
import com.example.VFSS.service.UserService;
import com.example.VFSS.service.UserServiceImpl;

@Controller
@RequestMapping("/createUser")
public class CreateUserController {
	
	@Autowired
	private final UserService userService;
	@Autowired
	HttpSession session;
	
	public CreateUserController(UserServiceImpl userServiceImpl) {
		this.userService = userServiceImpl;
	}
	
	@GetMapping("/form")
	public String goToCreateUser(@ModelAttribute UserForm userForm, Model model) {
			model.addAttribute(userForm);
			return "user/createUser";
	}
	
	@PostMapping("/insert")
	public String createUser(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("userForm", userForm);
			return "user/createUser";	
		}

		User user = new User();
		user.setUserId(userForm.getUserId());
		user.setPassword(userForm.getPassword());
		user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		user.setDeleteFlg(0);
			
		List<String> errorList = userService.insert(user);
			
		if(errorList.size() != 0) {
			model.addAttribute("errorList", errorList);
			return "user/createUser";
		}
		
		redirectAttributes.addFlashAttribute("loginMessage", "VFSSへようこそ！");
		session.setAttribute("loginUser", user);
		return "redirect:/subscription/index";
	}
}
