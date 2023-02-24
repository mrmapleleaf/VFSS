package com.example.VFSS.service.Validators;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionValidator {
	
	public static List<String> validate(String startingDateString, String monthlyFee) {
		List<String> errorList = new ArrayList<>();
		
		String startingDateError = validateInvalidDate(startingDateString);
		if(!startingDateError.equals("")) {
			errorList.add(startingDateError);
		}
		
		String monthlyFeeError = validateCharacterOfMonthlyFee(monthlyFee);
		if(!monthlyFeeError.equals("")) {
			errorList.add(monthlyFeeError);
		}
		
		return errorList;
	}
	
	public static String validateInvalidDate(String startingDateString) {
		
		LocalDate currentDate = LocalDate.now(); 
		LocalDate startingDate = LocalDate.parse(startingDateString);
		
		if(startingDate.isAfter(currentDate)) {
			return "利用開始日付には本日日付以前を指定してください";
		}
		
		return "";
	}
	
	public static String validateCharacterOfMonthlyFee(String monthlyFee) {
		if(!monthlyFee.matches("[0-9]+")) {
			return "月額利用料には半角数字のみを使用してください";
		}
		return "";
	}
}
