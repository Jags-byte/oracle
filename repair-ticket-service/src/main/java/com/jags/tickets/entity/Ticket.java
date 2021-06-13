package com.jags.tickets.entity;

import java.util.Date;

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

	private String ticketDescription;
	
	@ManyToOne
	private Customer customer;
	
	private String ticketStatus;
	
	private Date createdDate;
	
	private Date modifiedDate;
	

	public Ticket(String agentName, String ticketDescription, Customer customer) {
		this.agentName = agentName;
		this.customer = customer;
		this.ticketDescription = ticketDescription;
		ticketStatus = Constants.TICKET_ASSIGNED;
		this.createdDate = new Date();
		this.modifiedDate = new Date();
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


	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}


	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}


	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	/**
	 * @return the ticketDescription
	 */
	public String getTicketDescription() {
		return ticketDescription;
	}


	/**
	 * @param ticketDescription the ticketDescription to set
	 */
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	
	
	
	
	
}
