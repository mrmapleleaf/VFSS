package com.example.VFSS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.exception.SubscriptionNotFoundException;
import com.example.VFSS.form.SubscriptionForm;
import com.example.VFSS.service.SubscriptionService;

@Controller
@RequestMapping("/edit")
public class SubscriptionEditController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	public SubscriptionEditController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	

	@GetMapping("/{id}")
	public String goToEditPage(SubscriptionForm subscriptionForm, 
			@PathVariable String id, Model model) {
		int numId = 0;
		try {
			numId = Integer.parseInt(id);
		} catch(NumberFormatException e) {
			 throw new SubscriptionNotFoundException("指定されたIDのサブスクは存在しません");
		}
		
		Optional<Subscription> subOpt = subscriptionService.findSubscription(numId);
		Subscription sub = subOpt.orElseThrow(() -> new SubscriptionNotFoundException("指定されたIDのサブスクは存在しません"));

		subscriptionForm.setServiceName(sub.getServiceName());
		subscriptionForm.setMonthlyFee(String.valueOf(sub.getMonthlyFee()));
		subscriptionForm.setStartingDate(String.valueOf(sub.getStartingDate()));
		
		model.addAttribute("subscriptionForm", sub);
		model.addAttribute("subscriptionId", sub.getId());
		
		return "subscription/editSubscription";
	}
}
