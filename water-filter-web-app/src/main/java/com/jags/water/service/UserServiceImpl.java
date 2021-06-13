package com.jags.water.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jags.water.entity.User;
import com.jags.water.repository.AuthorityRepository;
import com.jags.water.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<String> retrieveRoles(String username) {
		return authorityRepository.findAuthorities(username);
	}
	
}
