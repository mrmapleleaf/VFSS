package com.example.VFSS.entity;

import java.sql.Timestamp;

public class Subscription {
	
	private int id;
	
	private String usersId;
	
	private String subscriptionName;
	
	private int monthlyFee;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private int deleteFlg;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsersId() {
		return this.usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	public String getSubscriptionName() {
		return this.subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public int getMonthlyFee() {
		return this.monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getDeleteFlg() {
		return this.deleteFlg;
	}

	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
