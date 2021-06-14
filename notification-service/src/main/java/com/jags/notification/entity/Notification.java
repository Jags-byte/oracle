package com.jags.notification.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification {

	@Id
	@GeneratedValue
	private int notificationId;
	private String username;
	private String message;
	private Date createdDate;
	
	public Notification(String username, String message) {
		this.username = username;
		this.message = message;
		this.createdDate = new Date();
	}
	
	
	public Notification() {
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String username) {
		this.username = username;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @return the notificationId
	 */
	public int getNotificationId() {
		return notificationId;
	}
	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	
	
	
}
