package com.jags.water.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jags.water.model.Ticket;
import com.jags.water.proxy.RepairTicketServiceProxy;

@Controller
public class FilterController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	RepairTicketServiceProxy repairTicketService;

	@GetMapping("/admin")
	public String adminDashboard(Model model) {
		logger.info(">>> Inside admin dashboard");
		List<Ticket> tickets = repairTicketService.retrieveAllTickets();
		logger.info("After Ticket Service " + tickets);
		model.addAttribute("tickets", tickets);
		//Read from config map
		String ticketServiceUri = System.getenv().getOrDefault("REPAIR_TICKET_SERVICE_URI", "http://localhost:8010");
		logger.info("ticketServiceUri: " + ticketServiceUri);
		model.addAttribute("serviceUri", ticketServiceUri);
		
		return "admin";
	}

	@GetMapping("/home")
	public String agentHome(Model model) {
		logger.info(">>> Inside Agent dashboard");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
        logger.info("Agent Name: {}", 	userDetails.getUsername());
		//Read from config map
		String ticketServiceUri = System.getenv().getOrDefault("REPAIR_TICKET_SERVICE_URI", "http://localhost:8010");
		String notificationServiceUri = System.getenv().getOrDefault("NOTIFICATION_SERVICE_URI", "http://localhost:8020");
		logger.info("ticketServiceUri: " + ticketServiceUri);
		logger.info("notificationServiceUri: " + notificationServiceUri);
		model.addAttribute("serviceUri", ticketServiceUri);
		model.addAttribute("notificationServiceUri", notificationServiceUri);
		model.addAttribute("refreshTimestamp", new Date().getTime());
		model.addAttribute("agentName", userDetails.getUsername());
		
		return "home";
	}
	@GetMapping("/admin/add")
	public String addTicket(Model model) {
		logger.info(">>> Inside addTicket");
		//Read from config map
		String ticketServiceUri = System.getenv().getOrDefault("REPAIR_TICKET_SERVICE_URI", "http://localhost:8010");
		logger.info("ticketServiceUri:: " + ticketServiceUri);
		model.addAttribute("serviceUri", ticketServiceUri);
		return "add";
	}
}
