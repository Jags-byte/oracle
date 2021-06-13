package com.jags.water.entity;

import java.io.Serializable;

public class AuthorityId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String authority;

	public AuthorityId(String username, String authority) {
		this.username = username;
		this.authority = authority;
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

	@Override
	public int hashCode() {
		int hash = 17;
		if (this.getAuthority() != null) {
			hash = 31 * hash + this.getAuthority().hashCode();
		}
		if (this.getUsername() != null) {
			hash = 31 * hash + this.getUsername().hashCode();
		}
		return hash;
	}
	

	@Override
	public boolean equals(Object obj) {
		
		if (obj == this) {
			return true;
		}
		
		if (obj == null || !(obj instanceof AuthorityId)) {
			return false;
		}
		
		AuthorityId authObj = (AuthorityId)obj;
		return this.getAuthority() != null && this.getAuthority().equals(authObj.getAuthority()) 
				&& this.getUsername().equals(authObj.getUsername());
		
	}

}
