package com.jags.water.controller;

import java.util.List;
import java.util.stream.Collectors;

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
		logger.info("### Inside admin dashboard");
		List<Ticket> tickets = repairTicketService.retrieveAllTickets();
		logger.info("### After Ticket Service " + tickets);
		
		model.addAttribute("msg", "First Message from Controller");
		model.addAttribute("tickets", tickets);
		return "admin";
	}

}
