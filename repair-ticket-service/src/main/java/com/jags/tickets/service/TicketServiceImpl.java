package com.jags.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jags.tickets.entity.Ticket;
import com.jags.tickets.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepository;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
}
