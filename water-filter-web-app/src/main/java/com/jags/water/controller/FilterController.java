package com.jags.water.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilterController {
	
	@GetMapping("test")
	public String test() {
		return "test";
	}

}
