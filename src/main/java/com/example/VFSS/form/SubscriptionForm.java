package com.example.VFSS.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class SubscriptionForm {

	@NotNull(message="サービス名が入力されていません")
	@Size(min=1, max=100, message="サービス名は1文字以上100文字以下で入力してください")
	private String serviceName;
	
	@NotEmpty(message="利用開始日付が入力されていません")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String startingDate;
	
	@NotNull(message="月額利用料が入力されていません")
	@Size(min=1, max=10, message="月額利用料金は1桁以上10桁以下で入力してください")
	private String monthlyFee;
	
	public SubscriptionForm(String serviceName, String startingDate, String monthlyFee) {
		this.serviceName = serviceName;
		this.startingDate = startingDate;
		this.monthlyFee = monthlyFee;
	}

	public SubscriptionForm() {
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getStartingDate() {
		return this.startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getMonthlyFee() {
		return this.monthlyFee;
	}

	public void setMonthlyFee(String monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
}
