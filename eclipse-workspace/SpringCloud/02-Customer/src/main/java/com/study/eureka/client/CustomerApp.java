package com.study.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CustomerApp {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApp.class, args);
	}
	
//	@LoadBalanced
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
//	@Bean
//	public IRule robbinRule() {
//		return new RandomRule();
//	}
	
}
