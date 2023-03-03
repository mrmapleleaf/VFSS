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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.VFSS.entity.Subscription;
import com.example.VFSS.entity.User;
import com.example.VFSS.form.SubscriptionForm;
import com.example.VFSS.service.SubscriptionService;
import com.example.VFSS.service.Validators.SubscriptionValidator;

@Controller
@RequestMapping("/register")
public class SubscriptionCreateController {
	
	@Autowired
	private final SubscriptionService subscriptionService;
	@Autowired
	HttpSession session;
	
	public SubscriptionCreateController(SubscriptionService subscriptionService) {
		this.subscriptionService = subscriptionService;
	}

	@GetMapping
	public String goToSubscriptionCreateForm(SubscriptionForm subscriptionForm, Model model) {
		model.addAttribute("subscriptionForm,", subscriptionForm);
		return "subscription/createSubscription";
	}
	
	@PostMapping("/insert")
	public String registerSubscription(@Valid @ModelAttribute SubscriptionForm subscriptionForm, BindingResult bindingResult
			,Model model, RedirectAttributes redirectAttrubutes) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("subscriptionForm", subscriptionForm);
			return "subscription/createSubscription";
		}
		
		List<String> errorList = SubscriptionValidator.validate(subscriptionForm.getStartingDate(), subscriptionForm.getMonthlyFee());
		if(errorList.size() != 0) {
			model.addAttribute("errorList", errorList);
			return "subscription/createSubscription";
		}

		User loginUser = (User)session.getAttribute("loginUser");
		
		Subscription subscription = new Subscription();
		subscription.setServiceName(subscriptionForm.getServiceName());
		subscription.setStartingDate(LocalDate.parse(subscriptionForm.getStartingDate()));
		subscription.setMonthlyFee(Integer.parseInt(subscriptionForm.getMonthlyFee()));
		subscription.setUsersId(loginUser.getId());
		subscription.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		subscription.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		subscriptionService.insert(subscription);
		
		redirectAttrubutes.addFlashAttribute("registerCompletedMessage", "サービス登録完了");
		return "redirect:/mysubscriptions/index";
	}
}
