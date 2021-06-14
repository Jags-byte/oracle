package com.jags.tickets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jags.tickets.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	public List<Ticket> findTicketByAgentNameOrderByCreatedDateDesc(String agentName);

}
