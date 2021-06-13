package com.jags.water.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	Logger logger = LoggerFactory.getLogger(CustomWebSecurityConfigurerAdapter.class);

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Inside configure method updated1");
		http.authorizeRequests()
			.antMatchers("/h2-console/**", "/login",  "/users/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/home", true)
			.and().csrf().disable();
		
		//Change X-Frame-Options for H2 Console
		http.headers().frameOptions().sameOrigin();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/webjars/**", "/v2/**", "/swagger-resources/**"); //Skip security check for static resources
	}

	
}
