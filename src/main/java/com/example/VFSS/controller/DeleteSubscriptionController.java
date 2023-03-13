package com.example.VFSS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.VFSS.exception.SubscriptionNotFoundException;
import com.example.VFSS.service.SubscriptionService;

@Controller
@RequestMapping("/subscription")
public class DeleteSubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	public DeleteSubscriptionController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@PostMapping("/delete")
	public String deleteSubscription(@RequestParam("subscriptionId") int subscriptionId, RedirectAttributes redirectAttributes) {
		if(subscriptionService.delete(subscriptionId) == 0) {
			throw new SubscriptionNotFoundException("指定されたIDのサブスクは存在しません");
		}
		
		redirectAttributes.addFlashAttribute("deleteCompletedMessage", "サブスクを削除しました");
		
		return "redirect:/mysubscriptions/index";
	}
}
