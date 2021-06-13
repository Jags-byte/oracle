package com.jags.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jags.tickets.entity.Ticket;
import com.jags.tickets.exception.TicketNotFoundException;
import com.jags.tickets.model.TicketModel;
import com.jags.tickets.service.TicketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(consumes = "application/json", produces="application/json")
public class TicketsController {
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("tickets")
	@ApiOperation(value = "Find all Ticket details", notes = "This API is for retrieving all Ticket details",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<List<Ticket>> retrieveAllTickets() {
		return new ResponseEntity<>(ticketService.findAllTickets(), HttpStatus.OK);
	}
	
	@GetMapping("tickets/{ticketId}")
	@ApiOperation(value = "Find all Ticket details", notes = "This API is for retrieving all Ticket details",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> retrieveTicket(@PathVariable int ticketId) throws TicketNotFoundException {
		Ticket ticket = ticketService.findTicket(ticketId);
		if (ticket == null) {
			throw new TicketNotFoundException();
		}
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	@GetMapping("tickets/agents/{agentName}")
	@ApiOperation(value = "Find Agent Tickets", notes = "This API is for retrieving all Ticket details for a particualr Agent",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<List<Ticket>> retrieveTicketsByAgent(@PathVariable String agentName) {
		return new ResponseEntity<>(ticketService.findTicketsByUser(agentName), HttpStatus.OK);
	}

	@PostMapping("tickets")
	@ApiOperation(value = "Create Tickets", notes = "This API is for creating new tickets and assign that to an Agent.",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> createTicket(@RequestBody TicketModel ticket) {
		return new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.CREATED);
	}

	@PostMapping("tickets/status")
	@ApiOperation(value = "Update Ticket Status", notes = "This API is for udpating Ticket Status.",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> updateTicketStatus(@RequestBody TicketModel ticket) {
		return new ResponseEntity<>(ticketService.updateTicketStatus(ticket.getTicketId(), ticket.getTicketStatus()), HttpStatus.OK);
	}

	@PostMapping("tickets/assign")
	@ApiOperation(value = "Assign Tickets", notes = "This API is for assigning a ticket to an Agent.",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> assingTicket(@RequestBody TicketModel ticket) {
		return new ResponseEntity<>(ticketService.assignTicket(ticket.getTicketId(), ticket.getAgentName()), HttpStatus.OK);
	}

}
