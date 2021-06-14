package com.jags.notification.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jags.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	@Query("SELECT n FROM Notification n WHERE n.username = ?1 and n.createdDate > ?2")
	List<Notification> findNotificationByUser(String username, Date startDate);
	
}
