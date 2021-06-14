package com.jags.tickets.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jags.tickets.entity.Ticket;
import com.jags.tickets.exception.TicketNotFoundException;
import com.jags.tickets.model.TicketModel;
import com.jags.tickets.service.TicketService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(consumes = "application/json", produces="application/json")
public class TicketsController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	TicketService ticketService;
	
	@GetMapping("tickets")
	@Retry(name="all-tickets", fallbackMethod = "retrieveAllTicketsRetryFallback")
	@ApiOperation(value = "Find all Ticket details", notes = "This API is for retrieving all Ticket details",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<List<Ticket>> retrieveAllTickets() {
		logger.info(">>> Entering tickets service");
		return new ResponseEntity<>(ticketService.findAllTickets(), HttpStatus.OK);
	}
	
	@GetMapping("tickets/{ticketId}")
	@ApiOperation(value = "Find Ticket details", notes = "This API is for retrieving Ticket details",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> retrieveTicket(@PathVariable int ticketId) throws TicketNotFoundException {
		logger.info(">>> Entering retrieve ticket service");
		Ticket ticket = ticketService.findTicket(ticketId);
		if (ticket == null) {
			throw new TicketNotFoundException();
		}
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	@CrossOrigin(origins = "${FILTER_APP_URI:http://localhost}:8000")
	@DeleteMapping("tickets/{ticketId}")
	@ApiOperation(value = "Delete Ticket", notes = "This API is for deleting a particular ticket.",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<String> deleteTicket(@PathVariable int ticketId) throws TicketNotFoundException {
		logger.info(">>> Entering delete ticket service");
		ticketService.deleteTicket(ticketId);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("tickets/agents/{agentName}")
	@CircuitBreaker(name="all-tickets", fallbackMethod = "retrieveAllTicketsCbFallback")
	@ApiOperation(value = "Find Agent Tickets", notes = "This API is for retrieving all Ticket details for a particualr Agent",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<List<Ticket>> retrieveTicketsByAgent(@PathVariable String agentName) {
		logger.info(">>> Entering agent tickets service");
		return new ResponseEntity<>(ticketService.findTicketsByUser(agentName), HttpStatus.OK);
	}

	@CrossOrigin(origins = "${FILTER_APP_URI:http://localhost}:8000")
	@PostMapping("tickets")
	@ApiOperation(value = "Create Tickets", notes = "This API is for creating new tickets and assign that to an Agent.",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> createTicket(@RequestBody TicketModel ticket) {
		logger.info(">>> Entering create tickets service");
		return new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "${FILTER_APP_URI:http://localhost}:8000")
	@PostMapping("tickets/status")
	@ApiOperation(value = "Update Ticket Status", notes = "This API is for udpating Ticket Status.",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> updateTicketStatus(@RequestBody TicketModel ticket) {
		logger.info(">>> Entering udpate ticket status service");
		logger.info("Ticket Details: " + ticket);
		return new ResponseEntity<>(ticketService.updateTicketStatus(ticket.getTicketId(), ticket.getTicketStatus()), HttpStatus.OK);
	}

	@PostMapping("tickets/assign")
	@ApiOperation(value = "Assign Tickets", notes = "This API is for assigning a ticket to an Agent.",
			tags = {"Ticket"}, httpMethod = "GET")
	public ResponseEntity<Ticket> assingTicket(@RequestBody TicketModel ticket) {
		logger.info(">>> Entering assign ticket service");
		return new ResponseEntity<>(ticketService.assignTicket(ticket.getTicketId(), ticket.getAgentName()), HttpStatus.OK);
	}

	/**
	 * Retry Fallback
	 * @return
	 */
	public ResponseEntity<List<Ticket>> retrieveAllTicketsRetryFallback(Exception ex) {
		logger.info(">>> >>> Entering retrieveAllTicketsRetryFallback: " + ex.getMessage());
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	/**
	 * Circuit Breaker Fallback
	 * @return
	 */
	public ResponseEntity<List<Ticket>> retrieveAllTicketsCbFallback(Exception ex) {
		logger.info(">>> >>> Entering retrieveAllTicketsCbFallback: " + ex.getMessage());
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
