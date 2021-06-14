package com.jags.notification.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jags.notification.entity.Notification;
import com.jags.notification.repository.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	NotificationRepository repository;

	public List<Notification> findNotificationsByUser(String username, long startTime) {
		LocalDateTime date;
		if (startTime == 0) {
			date = LocalDateTime.now().minusDays(1);
		} else {
			date = LocalDateTime.ofInstant(Instant.ofEpochMilli(startTime), TimeZone.getDefault().toZoneId());
		}
		logger.info(">>> Inside findNotificationsByUser: " + date);
		List<Notification> notifications = repository.findNotificationByUser(username, Date.from(date.atZone(ZoneId.systemDefault()).toInstant()));
		logger.info("Nofications: " + notifications);
		logger.info("Nofications: " + notifications.size());
		return notifications;
	}

	public Notification createNotification(String username, String message) {
		logger.info(">>> Inside createNotification, user: {}, message: {}", username, message);
		return repository.save(new Notification(username, message));
	}

}
