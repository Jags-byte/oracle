package com.jags.water.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId.class)
public class Authority {

	@NotNull
	@Id
	private String username;
	
	@NotNull
	@Id
	private String authority;
	
	

	public Authority(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
