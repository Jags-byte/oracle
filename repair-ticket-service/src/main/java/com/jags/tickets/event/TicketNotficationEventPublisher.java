package com.jags.tickets.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.nats.client.Connection;
import io.nats.client.Nats;

@Component
public class TicketNotficationEventPublisher {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public void publishTicketCreationEvent(String agentName, String message) {
		logger.info(">>> Inside TicketNotficationEventPublisher: publishTicketCreationEvent");
		try {
			//Read from config map
			String natsUri = System.getenv().getOrDefault("NATS_SERVER_URI", "nats://localhost:4222");
			logger.info("natsUri: " + natsUri);
			logger.info("Message Publish: " + agentName + "|" + message);
			Connection connect = Nats.connect(natsUri);
			connect.publish("com.jags.tickets", (agentName + "|" + message).getBytes());
			
		} catch (Exception e) {
			logger.error("Failed to Publish Notification Event: " + e.getMessage(), e);
		}
	}
}
