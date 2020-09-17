package com.study.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.eureka.entity.Customer;

@RestController
public class SearchController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/search")
	public String search() {
		return "search：" + port;
	}
	
	@GetMapping( "/search/{id}" )
	public Customer findById(@PathVariable Integer id) {
		return new Customer(1,"张三",23);
	}
	
	@GetMapping("/getCustomer")
	public Customer findById(@RequestParam Integer id,@RequestParam String name) {
		return new Customer(id,name,23);
	}
	
	@GetMapping("/save")
	public Customer save(Customer cust) {
		return cust;
	}
	
}
