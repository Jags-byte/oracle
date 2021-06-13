package com.jags.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jags.tickets.entity.TicketType;
import com.jags.tickets.repository.TicketTypeRepository;

@Service
public class TicketTypeServiceImpl implements TicketTypeService{

	@Autowired
	TicketTypeRepository ticketTypeRepo;
	
	public TicketType addTicketType(TicketType ticketType) {
		return ticketTypeRepo.save(ticketType);
	}
}
