package com.jags.tickets;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.jags.tickets.entity.TicketType;
import com.jags.tickets.service.CustomerService;
import com.jags.tickets.service.TicketService;
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
		
		TicketType t1 = ticketTypeService.addTicketType(new TicketType("FREE SERVICE", "Free Service within the warranty period"));
		TicketType t2 = ticketTypeService.addTicketType(new TicketType("PAID SERVICE", "Paid Service"));
		TicketType t3 = ticketTypeService.addTicketType(new TicketType("URGENT REPAIR", "Urgent Request for Repair"));
		TicketType t4 = ticketTypeService.addTicketType(new TicketType("CUSTOMER COMPLAINT", "Customer complaint"));
		
		Customer c1  = customerService.addCustomer(new Customer("Mike George", "Mankato Mississippi 96522", "234 234 2345"));
		Customer c2  = customerService.addCustomer(new Customer("Bruce Wills", "Roseville NH 11523", "536 234 2345"));
		Customer c3  = customerService.addCustomer(new Customer("Tina M", "San Antonio MI 47096", "865 234 2345"));
		Customer c4  = customerService.addCustomer(new Customer("Sai Ganesh", "Corona New Mexico 08219", "234 858 2345"));
		Customer c5  = customerService.addCustomer(new Customer("Philip Mathew", "Muskegon KY 12482", "234 435 9999"));
		
		List<String> users = Arrays.asList("agent1", "agent2", "agent3");
		List<Customer> customers = Arrays.asList(c1, c2, c3, c4, c5);
		List<TicketType> ticketTypes = Arrays.asList(t1, t2, t3, t4);
		
		
		for (int i = 0; i < 100; i++) {
			ticketService.createTicket(new Ticket(users.get((int) (Math.random() * 100) %3), 
					customers.get((int) (Math.random() * 100) %5), ticketTypes.get((int) (Math.random() * 100) %4)));
		}

	} 

}
