package com.jags.tickets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import com.jags.tickets.entity.Ticket;
import com.jags.tickets.repository.TicketRepository;
import com.jags.tickets.service.TicketServiceImpl;

@ExtendWith(MockitoExtension.class)
class TicketsServiceTest {

	@Mock
	TicketRepository ticketRepository;
	
	@InjectMocks
	TicketServiceImpl ticketService;
	
	@Test
	public void findAllTest() {
		Mockito.when(ticketRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"))).thenReturn(Arrays.asList(
				new Ticket(101, "agent1", "Ticket Description"),
				new Ticket(102, "agent1", "Ticket Description"),
				new Ticket(103, "agent1", "Ticket Description")
				));
		assertEquals(101, ticketService.findAllTickets().get(0).getTicketId());
	}

	@Test
	public void udpateTicketStatusTest() {
		Optional<Ticket> op = Optional.of(new Ticket(101, "agent1", "Ticket Description"));
		Mockito.when(ticketRepository.findById(101)).thenReturn(op);
		Mockito.when(ticketRepository.save(Mockito.any())).thenReturn(
				new Ticket(101, "agent1", "Ticket Description"));
		assertEquals("ASSIGNED", ticketService.updateTicketStatus(101, "ASSIGNED").getTicketStatus());
	}
}
