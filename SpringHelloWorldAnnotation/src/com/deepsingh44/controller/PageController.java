package com.deepsingh44.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String mainPage() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
}