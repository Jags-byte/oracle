package com.jags.notification.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jags.notification.entity.Notification;
import com.jags.notification.service.NotificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(consumes = "application/json", produces="application/json")
public class NotificationController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	NotificationService notificationService;
	
	@CrossOrigin(origins = "${FILTER_APP_URI:http://localhost:8000}")
	@GetMapping("notifications/{username}/{startTime}")
	@ApiOperation(value = "Retrieve Notifications", notes = "This API is for retrieving notifications for a user",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<List<Notification>> retrieveNotification(@PathVariable String username, @PathVariable long startTime) {
		logger.info(">>> Entering retrieve notification service");
		return new ResponseEntity<>(notificationService.findNotificationsByUser(username, startTime), HttpStatus.OK);
	}
}
