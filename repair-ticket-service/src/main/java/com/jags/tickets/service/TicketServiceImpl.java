package com.jags.tickets.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jags.tickets.entity.Customer;
import com.jags.tickets.entity.Ticket;
import com.jags.tickets.model.TicketModel;
import com.jags.tickets.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	TicketRepository ticketRepository;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> findAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findTicket(int ticketId) {
		return ticketRepository.findById(ticketId).get();
	}

	@Override
	public List<Ticket> findTicketsByUser(String username) {
		return ticketRepository.findTicketByAgentName(username);
	}

	@Override
	public Ticket updateTicketStatus(int ticketId, String ticketStatus) {
		Optional<Ticket> findById = ticketRepository.findById(ticketId);
		Ticket ticket = findById.get();
		ticket.setTicketStatus(ticketStatus);;
		ticket.setModifiedDate(new Date());
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket assignTicket(int ticketId, String username) {
		Optional<Ticket> findById = ticketRepository.findById(ticketId);
		Ticket ticket = findById.get();
		ticket.setAgentName(username);;
		ticket.setModifiedDate(new Date());
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket createTicket(TicketModel ticket) {
		return ticketRepository.save(prepareTicket(ticket));
	}

	/**
	 * Maps the TicketModel to the Entity Object
	 * @param ticketModel
	 * @return
	 */
	private static Ticket prepareTicket(TicketModel ticketModel) {
		Ticket ticket = new Ticket();
		ticket.setTicketId(ticketModel.getTicketId());
		ticket.setAgentName(ticketModel.getAgentName());
		ticket.setTicketDescription(ticketModel.getTicketDescription());
		if (ticketModel.getCustomerId() != 0) {
			ticket.setCustomer(new Customer(ticketModel.getCustomerId()));
		}
		ticket.setTicketStatus(ticketModel.getTicketStatus());
		Date d = new Date();
		if (ticketModel.getTicketId() == 0) {
			ticket.setCreatedDate(d);
		} 
		ticket.setModifiedDate(d);
		return ticket;
	}

}
