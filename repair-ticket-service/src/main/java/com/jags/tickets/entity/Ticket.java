package com.jags.tickets.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.jags.tickets.common.Constants;
import com.sun.istack.NotNull;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue
	private int ticketId;
	
	@NotNull
	private String agentName;

	@ManyToOne
	private TicketType ticketType;
	
	@ManyToOne
	private Customer customer;
	
	private String ticketStatus;
	

	public Ticket(String agentName, Customer customer, TicketType ticketType) {
		this.agentName = agentName;
		this.customer = customer;
		this.ticketType = ticketType;
		ticketStatus = Constants.TICKET_ASSIGNED;
	}


	public Ticket() {
		super();
	}


	/**
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}


	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}


	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}


	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}


	/**
	 * @return the ticketType
	 */
	public TicketType getTicketType() {
		return ticketType;
	}


	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}


	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/**
	 * @return the ticketStatus
	 */
	public String getTicketStatus() {
		return ticketStatus;
	}


	/**
	 * @param ticketStatus the ticketStatus to set
	 */
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	
	
	
	
}
