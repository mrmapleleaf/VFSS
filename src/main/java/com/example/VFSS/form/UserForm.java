package com.example.VFSS.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {
	
	@NotNull(message="ユーザーIDが入力されていません")
	@Size(min=1, max=20, message="ユーザーIDは1文字以上20文字以下で入力してください")
	private String userId;
	@NotNull(message="パスワードが入力されていません")
	@Size(min=1, message="パスワードは1文字以上で入力してください")
	private String password;
	
	public UserForm(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
