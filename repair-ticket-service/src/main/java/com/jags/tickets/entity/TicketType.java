package com.jags.tickets.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketType {

	@Id
	private String type;
	private String description;
	
	
	public TicketType(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}
	
	
	public TicketType() {
		super();
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
