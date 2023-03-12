package com.example.VFSS.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.form.SubscriptionForm;
import com.example.VFSS.service.SubscriptionService;
import com.example.VFSS.service.Validators.SubscriptionValidator;

@Controller
@RequestMapping("/subscription")
public class SubscriptionUpdateController {
	
	@Autowired
	SubscriptionService subscriptionService;
	@Autowired
	HttpSession session;
	
	public SubscriptionUpdateController (SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
		
	}

	@PostMapping("update")
	public String update(@Valid @ModelAttribute SubscriptionForm subscriptionForm, 
			BindingResult bindingResult, @RequestParam("subscriptionId") int subscriptionId 
			,Model model, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("subscriptionForm", subscriptionForm);
			model.addAttribute("subscriptionId", subscriptionId);
			return "subscription/editSubscription";
		}
		
		List<String> errorList = SubscriptionValidator.validate(subscriptionForm.getStartingDate(), subscriptionForm.getMonthlyFee());
		if(errorList.size() != 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("subscriptionId", subscriptionId);
			return "subscription/editSubscription";
		}
		
		Subscription subscription = new Subscription();
		subscription.setServiceName(subscriptionForm.getServiceName());
		subscription.setStartingDate(LocalDate.parse(subscriptionForm.getStartingDate()));
		subscription.setMonthlyFee(Integer.parseInt(subscriptionForm.getMonthlyFee()));
		subscription.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		subscriptionService.update(subscription, subscriptionId);
		redirectAttributes.addFlashAttribute("UpdateCompletedMessage", "更新完了");
		
		return "redirect:/mysubscriptions/index";
	}
}
