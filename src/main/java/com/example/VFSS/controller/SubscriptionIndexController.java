package com.example.VFSS.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.entity.User;
import com.example.VFSS.service.SubscriptionService;

@Controller
@RequestMapping("/mysubscriptions")
public class SubscriptionIndexController {
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private HttpSession session;
	
	public SubscriptionIndexController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}
	
	@GetMapping("/index")
	public String goToIndex(Model model) {
		User loginUser = (User)session.getAttribute("loginUser");
		List<Subscription> subscriptionList = subscriptionService.findAllSubscriptions(loginUser.getId());
		model.addAttribute("subscriptionList", subscriptionList);
		return "index";
	}
}
