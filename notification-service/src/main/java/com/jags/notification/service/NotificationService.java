package com.jags.notification.service;

import java.util.List;

import com.jags.notification.entity.Notification;

public interface NotificationService {
	
	public List<Notification> findNotificationsByUser(String username, long startTime);
	
	public Notification createNotification(String username, String message);

}
