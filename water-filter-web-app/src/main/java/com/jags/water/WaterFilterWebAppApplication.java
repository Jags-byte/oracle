package com.jags.water;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class WaterFilterWebAppApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(WaterFilterWebAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WaterFilterWebAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inside Water Filter Application");

	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jags.water.controller"))
				.paths(PathSelectors.ant("/**/**")).build().apiInfo(apiInfo());
	}
	
	 private ApiInfo apiInfo() {
	        return new ApiInfo(
	          "User API", 
	          "User API Service Description", 
	          "v1",
	          "User API Terms Of Service", 
	          new Contact("Contact", "www.support.com", ""), 
	          "License of API", "API license URL", new ArrayList<>());
	   } 
}
