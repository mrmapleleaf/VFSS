package com.example.VFSS.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Subscription implements Serializable {
	
	private static final long serialVersionUID = -870708489937857961L;
	
	private int id;
	
	private int usersId;
	
	private String serviceName;
	
	private int monthlyFee;
	
	private LocalDate startingDate;

	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private int deleteFlg;
	
	private long usagePeriod;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsersId() {
		return this.usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}


	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getMonthlyFee() {
		return this.monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	public LocalDate getStartingDate() {
		return this.startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
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

	public long getUsagePeriod() {
		return this.usagePeriod;
	}

	public void setUsagePeriod(long usagePeriod) {
		this.usagePeriod = usagePeriod;
	}
}
