package com.jags.water.service;

import java.util.List;

import com.jags.water.entity.User;

public interface UserService {
	public List<User> retrieveAllUsers();

	public List<String> retrieveRoles(String username);
	
}
