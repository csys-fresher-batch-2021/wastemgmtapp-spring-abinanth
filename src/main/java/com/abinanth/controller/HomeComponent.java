package com.abinanth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeComponent {
	@GetMapping
	public String getString() {
		return "index.jsp";
	}
	

}
