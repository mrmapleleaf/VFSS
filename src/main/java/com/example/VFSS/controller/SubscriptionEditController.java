package com.example.VFSS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.exception.SubscriptionNotFoundException;
import com.example.VFSS.form.SubscriptionForm;
import com.example.VFSS.service.SubscriptionService;

@Controller
@RequestMapping("/subscription")
public class SubscriptionEditController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	public SubscriptionEditController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	

	@PostMapping("/edit")
	public String goToEditPage(SubscriptionForm subscriptionForm, 
			@RequestParam("subscriptionId") int id, Model model) {
		
		Optional<Subscription> subOpt = subscriptionService.findSubscription(id);
		Subscription sub = subOpt.orElseThrow(() -> new SubscriptionNotFoundException("指定されたIDのサブスクは存在しません"));

		subscriptionForm.setServiceName(sub.getServiceName());
		subscriptionForm.setMonthlyFee(String.valueOf(sub.getMonthlyFee()));
		subscriptionForm.setStartingDate(String.valueOf(sub.getStartingDate()));
		
		model.addAttribute("subscriptionForm", sub);
		model.addAttribute("subscriptionId", sub.getId());
		
		return "subscription/editSubscription";
	}
}
