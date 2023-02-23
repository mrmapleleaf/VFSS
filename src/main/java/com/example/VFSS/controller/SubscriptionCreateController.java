package com.example.VFSS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.VFSS.form.SubscriptionForm;

@Controller
@RequestMapping("/register")
public class SubscriptionCreateController {

	@GetMapping
	public String goToSubscriptionCreateForm(SubscriptionForm subscriptionForm, Model model) {
		model.addAttribute("SubscriptionForm,", subscriptionForm);
		return "subscription/createSubscription";
	}
}
