package com.study.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/list")
	public String list() {
		return "Other-Service : list()";
	}
}
