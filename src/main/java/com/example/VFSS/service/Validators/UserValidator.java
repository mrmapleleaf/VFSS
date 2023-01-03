package com.example.VFSS.service.Validators;

import java.util.ArrayList;
import java.util.List;

import com.example.VFSS.entity.User;

public class UserValidator {

	public static List<String> validate(User user) {
		List<String> errorList = new ArrayList<>();
		
		String userIdError = validateCharacterOfUserID(user);
		if(!userIdError.equals("")) {
			errorList.add(userIdError);
		}
		
		String passwordError  = validateCharacterOfPassword(user);
		if(!passwordError.equals("")) {
			errorList.add(passwordError);
		}
		
		return errorList;
	}
	
	public static String validateCharacterOfUserID(User user) {
		if(!user.getUserId().matches("[a-z0-9]+")) {
			return "ユーザーIDには半角小文字の英数字のみを使用してください";
		}
		return "";
	}
	
	public static String validateCharacterOfPassword(User user) {
		if(!user.getPassword().matches("[A-Za-z0-9]+")) {
			return "パスワードには半角大文字、小文字の英字、半角数字のみを使用してください";
		}
		return "";
	}
	
}
