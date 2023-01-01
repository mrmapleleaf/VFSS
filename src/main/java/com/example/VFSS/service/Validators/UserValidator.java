package com.example.VFSS.service.Validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.VFSS.entity.User;
import com.example.VFSS.repository.UserDAO;
import com.example.VFSS.repository.UserDAOImpl;

public class UserValidator {

	@Autowired
	private final UserDAO userDao;
	
	public UserValidator(UserDAOImpl userDaoImpl) {
		this.userDao = userDaoImpl;
	}
	
	public static String validateCharacterOfUserID(User user) {
		if(!user.getUserId().matches("[a-z0-9]+")) {
			return "ユーザーIDには半角小文字の英数字のみを使用してください";
		}
		return "";
	}
	
	public static String validateCharacterOfPassword(User user) {
		if(!user.getPassword().matches("[A-Za-z0-9]+")) {
			return "パスワードには半角大文字か小文字の英字と半角数字のみを使用してください";
		}
		return "";
	}
	
	//ユーザーID被りをバリデーションする
	
}
