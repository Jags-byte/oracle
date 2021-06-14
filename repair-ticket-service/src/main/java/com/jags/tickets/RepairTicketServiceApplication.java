package com.jags.tickets;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jags.tickets.entity.Customer;
import com.jags.tickets.entity.Ticket;
import com.jags.tickets.service.CustomerService;
import com.jags.tickets.service.TicketService;

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
	CustomerService customerService;
	@Autowired
	TicketService ticketService;
	
	
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
		
		Customer c1  = customerService.addCustomer(new Customer(100, "Mike George", "Mankato Mississippi 96522", "234 234 2345"));
		Customer c2  = customerService.addCustomer(new Customer(101, "Bruce Wills", "Roseville NH 11523", "536 234 2345"));
		Customer c3  = customerService.addCustomer(new Customer(102, "Tina M", "San Antonio MI 47096", "865 234 2345"));
		Customer c4  = customerService.addCustomer(new Customer(103, "Sai Ganesh", "Corona New Mexico 08219", "234 858 2345"));
		Customer c5  = customerService.addCustomer(new Customer(104, "Philip Mathew", "Muskegon KY 12482", "234 435 9999"));
		
		List<String> users = Arrays.asList("agent1", "agent2", "agent3");
		List<Customer> customers = Arrays.asList(c1, c2, c3, c4, c5);
		List<String> ticketDescription = Arrays.asList("FREE SERVICE", "PAID SERVICE", "URGENT REPAIR", "CUSTOMER COMPLAINT");
		
		List<LocalDate> dateLst = new ArrayList<>();
		LocalDate date = LocalDate.now();
		dateLst.add(date);
		for (int i = 0; i < 3; i++) {
			date = date.minusDays(1);
			dateLst.add(date);
		}
		for (int i = 0; i < 100; i++) {
			Ticket t = new Ticket(users.get((int) (Math.random() * 100) %3), 
					ticketDescription.get((int) (Math.random() * 100) %4), 
					customers.get((int) (Math.random() * 100) %5));
			Date d = Date.from(dateLst.get((int) (Math.random() * 100) %3).atStartOfDay(ZoneId.systemDefault()).toInstant());
			t.setCreatedDate(d);
			t.setModifiedDate(d);
			ticketService.createTicket(t);
		}

	} 

}
