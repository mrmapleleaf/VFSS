package com.example.VFSS.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.VFSS.service.Validators.UserValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private final UserService userService;
	@Autowired
	private HttpSession session;
	
	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/form")
	public String goToLoginForm(@ModelAttribute UserForm userForm, Model model) {
		model.addAttribute(userForm);
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {

		if(bindingResult.hasErrors()) {
			model.addAttribute("userForm", userForm);
			return "login/login";
		}
			
		List<String> errorList = UserValidator.validate(userForm.getUserId(), userForm.getPassword());
		if(errorList.size() != 0) {
			model.addAttribute("errorList", errorList);
			return "login/login";
		}
			
		Optional<User> OptionalLoginUser = userService.findUser(userForm.getUserId(), userForm.getPassword());
		if(OptionalLoginUser == null) {
			errorList.add("ユーザーIDかパスワードが間違っています");
			model.addAttribute("errorList", errorList);
			return "login/login";
		}
		
		User loginUser = OptionalLoginUser.get();
		redirectAttributes.addFlashAttribute("loginMessage", "ログインしました");
		session.setAttribute("loginUser", loginUser);
		return "redirect:/mysubscriptions/index";
	}
}
