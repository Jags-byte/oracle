package com.jags.tickets.service;

import java.util.List;

import com.jags.tickets.entity.Ticket;
import com.jags.tickets.model.TicketModel;

public interface TicketService {

	public Ticket createTicket(Ticket ticket);

	public List<Ticket> findAllTickets();
	
	public Ticket findTicket(int ticketId);
	
	public List<Ticket> findTicketsByUser(String username);
	
	public Ticket updateTicketStatus(int ticketId, String ticketStatus);

	public Ticket assignTicket(int ticketId, String username);

	public Ticket createTicket(TicketModel ticket);

	public void deleteTicket(int ticketId);

}
