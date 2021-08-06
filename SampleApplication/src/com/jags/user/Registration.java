package com.jags.user;

import java.util.Date;
import java.util.List;

public class Registration {
	private double registrationId;
	private String registeredMobileNumber;
	private Date createdDate;
	
	private List<User> userList;

	
	public Registration(String registeredMobileNumber, Date date) {
		super();
		this.registrationId = Math.random();
		this.registeredMobileNumber = registeredMobileNumber;
		this.createdDate = date;
	}

	/**
	 * @return the registrationId
	 */
	public double getRegistrationId() {
		return registrationId;
	}

	

	/**
	 * @return the registeredMobileNumber
	 */
	public String getRegisteredMobileNumber() {
		return registeredMobileNumber;
	}

	/**
	 * @param registeredMobileNumber the registeredMobileNumber to set
	 */
	public void setRegisteredMobileNumber(String registeredMobileNumber) {
		this.registeredMobileNumber = registeredMobileNumber;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Registration [registrationId=");
		builder.append(registrationId);
		builder.append(", registeredMobileNumber=");
		builder.append(registeredMobileNumber);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", userList=");
		builder.append(userList);
		builder.append("]\n");
		return builder.toString();
	}
	
	

	
}
