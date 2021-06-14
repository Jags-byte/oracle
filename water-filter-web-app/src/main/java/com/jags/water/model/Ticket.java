package com.jags.water.model;

import java.util.Date;

public class Ticket {
	
	private int ticketId;
	private String agentName;
	private String ticketDescription;
	private Customer customer;
	private String ticketStatus;
	private Date createdDate;
	private Date modifiedDate;
	
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
