package com.example.VFSS.entity;

import java.sql.Timestamp;

public class User {

	private int id;
	
	private String userId;
	
	private String password;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private int deleteFlg;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
