package com.jags.water.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        logger.info("########## User logged in: {}", userDetails.getUsername());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String redirectUrl = "/home";
        for (GrantedAuthority auth : authorities) {
        	logger.info("Auth: " + auth.getAuthority());
        	if ("ADMIN".equalsIgnoreCase(auth.getAuthority())) {
        		redirectUrl = "/admin";
        		break;
        	}
		}
         
        response.sendRedirect(redirectUrl);
    }
}