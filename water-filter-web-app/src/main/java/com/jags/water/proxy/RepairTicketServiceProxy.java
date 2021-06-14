package com.jags.water.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.jags.water.model.Ticket;

@FeignClient(name="repair-ticket-service", url = "${REPAIR_TICKET_SERVICE_URI:http://localhost:8010}")
public interface RepairTicketServiceProxy {
	
	
	@GetMapping("tickets")
	public List<Ticket> retrieveAllTickets();
}
