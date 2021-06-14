package com.jags.notification;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jags.notification.service.NotificationService;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class NotificationServiceApplication implements CommandLineRunner{
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	NotificationService notificationService;
	
	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jags.notification.controller"))
				.paths(PathSelectors.ant("/**/**")).build().apiInfo(apiInfo());
	}
	
	 private ApiInfo apiInfo() {
	        return new ApiInfo(
	          "User API", 
	          "User API Service Description", 
	          "v1",
	          "User API Terms Of Service", 
	          new Contact("Contact", "www.support.com", ""), 
	          "License of API", "API license URL", new ArrayList<>());
	   } 
	 
	@Override
	public void run(String... args) throws Exception {
		logger.info(">>> Inside NotificationServiceApplication");
		try {
			//Read from config map
			String natsUri = System.getenv().getOrDefault("NATS_SERVER_URI", "nats://localhost:4222");
			logger.info("natsUri: " + natsUri);
			Connection connect = Nats.connect(natsUri);
			Dispatcher dispatcher = connect.createDispatcher(msg -> {
				String message = new String(msg.getData(), StandardCharsets.UTF_8);
				logger.info(">>> Inside NotificationServiceApplication, Received Message: " + message);
				String[] msgArr = message.split("\\|");
				notificationService.createNotification(msgArr[0], msgArr[1]);
			});
			dispatcher.subscribe("com.jags.tickets");
			
			connect.publish("com.jags.tickets", "First Message".getBytes());
			
		} catch (Exception e) {
			logger.error("Failed to connect to NATS server: " + e.getMessage(), e);
		}
	}

}
