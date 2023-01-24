package com.example.VFSS.service.Validators;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

	public static List<String> validate(String userId, String password) {
		List<String> errorList = new ArrayList<>();
		
		String userIdError = validateCharacterOfUserID(userId);
		if(!userIdError.equals("")) {
			errorList.add(userIdError);
		}
		
		String passwordError  = validateCharacterOfPassword(password);
		if(!passwordError.equals("")) {
			errorList.add(passwordError);
		}
		
		return errorList;
	}
	
	public static String validateCharacterOfUserID(String userId) {
		if(!userId.matches("[a-z0-9]+")) {
			return "ユーザーIDには半角小文字の英数字のみを使用してください";
		}
		return "";
	}
	
	public static String validateCharacterOfPassword(String password) {
		if(!password.matches("[A-Za-z0-9]+")) {
			return "パスワードには半角大文字、小文字の英字、半角数字のみを使用してください";
		}
		return "";
	}
	
}
