package com.jags.water;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("mylogin");
		registry.addViewController("/home").setViewName("home");
		//registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/error").setViewName("error");
	}

	
	
}
