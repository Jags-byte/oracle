package com.jags.tickets;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jags.tickets.entity.TicketType;
import com.jags.tickets.service.TicketTypeService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class RepairTicketServiceApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(RepairTicketServiceApplication.class);

	@Autowired
	TicketTypeService ticketTypeService;
	
	public static void main(String[] args) {
		SpringApplication.run(RepairTicketServiceApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jags.water.controller"))
				.paths(PathSelectors.ant("/**/**")).build().apiInfo(apiInfo());
	}
	
	 private ApiInfo apiInfo() {
	        return new ApiInfo(
	          "Tickets API", 
	          "Tickets API Service Description", 
	          "v1",
	          "Tickets API Terms Of Service", 
	          new Contact("Contact", "www.support.com", ""), 
	          "License of API", "API license URL", new ArrayList<>());
	   }

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inside RepairTicketServiceApplication");
		
		ticketTypeService.addTicketType(new TicketType("FREE SERVICE", "Free Service within the warranty period"));
		ticketTypeService.addTicketType(new TicketType("PAID SERVICE", "Paid Service"));
		ticketTypeService.addTicketType(new TicketType("URGENT REPAIR", "Urgent Request for Repair"));
		ticketTypeService.addTicketType(new TicketType("CUSTOMER COMPLAINT", "Customer complaint"));
	} 

}
