
package com.jags.water.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/h2-console/**", "/swagger-ui/**").permitAll() 
				.anyRequest() 
				.authenticated() 
				.and().formLogin().loginPage("/login") //Form Based Authentication
				.defaultSuccessUrl("/home", true) 
				.and().csrf().disable() //For H2 Console.
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login");

		//Disable X-Frame options
		http.headers().frameOptions().disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/webjars/**", "/js/**", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html", "/v2/**", "/swagger-resources/**"); 
	}

}
