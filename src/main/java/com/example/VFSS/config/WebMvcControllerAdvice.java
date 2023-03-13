package com.example.VFSS.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.VFSS.exception.InvalidPagenationException;
import com.example.VFSS.exception.SubscriptionNotFoundException;

@ControllerAdvice
public class WebMvcControllerAdvice {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@ExceptionHandler(InvalidPagenationException.class)
	public String handleException(InvalidPagenationException e) {
		return "error";
	}
	
	@ExceptionHandler(SubscriptionNotFoundException.class)
	public String handleException(SubscriptionNotFoundException e) {
		return "error";
	}
}
