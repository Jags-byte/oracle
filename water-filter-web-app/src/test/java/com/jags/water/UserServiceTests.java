package com.jags.water;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jags.water.entity.User;
import com.jags.water.repository.AuthorityRepository;
import com.jags.water.repository.UserRepository;
import com.jags.water.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceTests {
	
	@Mock
	AuthorityRepository authRepo;
	
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
	UserServiceImpl userService;

	@Test
	void retrieveUserRole() {
		Mockito.when(authRepo.findAuthorities("jags")).thenReturn(Arrays.asList("USER"));
		assertEquals("USER", userService.retrieveRoles("jags").get(0));
	}
	
	@Test
	void retrieveUserDetails() {
		Mockito.when(userRepo.findAll()).thenReturn(Arrays.asList(new User("username", "fname", 
				"lname", "pwd", "email"
				)));
		assertEquals("username", userService.retrieveAllUsers().get(0).getUsername());
	}

}
