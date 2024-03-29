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
import com.example.VFSS.service.SubscriptionService;

@Controller
@RequestMapping("/show")
public class SubscriptionShowController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	public SubscriptionShowController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@GetMapping("/{id}")
	public String goToDetails(@PathVariable String id, Model model) {
		int numId = 0;
		try {
			numId = Integer.parseInt(id);
		} catch(NumberFormatException e) {
			 new SubscriptionNotFoundException("指定されたIDのサブスクは存在しません");
		}
		
		Optional<Subscription> subOpt = subscriptionService.findSubscription(numId);
		Subscription sub = subOpt.orElseThrow(() -> new SubscriptionNotFoundException("指定されたIDのサブスクは存在しません"));
		
		model.addAttribute("subscription", sub);
		
		return "/subscription/showSubscription";
	}
}
