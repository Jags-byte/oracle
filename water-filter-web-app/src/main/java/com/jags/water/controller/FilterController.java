package com.jags.water.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
