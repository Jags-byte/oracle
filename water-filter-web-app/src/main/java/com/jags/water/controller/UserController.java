package com.jags.water.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jags.water.entity.User;
import com.jags.water.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(consumes = "application/json", produces="application/json")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("users")
	@ApiOperation(value = "Find all User details", notes = "This API is for retrieving all user details",
			tags = {"User"}, httpMethod = "GET")
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}
	
	@GetMapping("users/authorities/{username}")
	@ApiOperation(value = "Retrieve roles for a User", notes = "This API is for retrieving all roles for a user",
			tags = {"User"}, httpMethod = "GET")
	public List<String> retrieveRoles(@PathVariable String username) {
		return userService.retrieveRoles(username);
	}
	
}
