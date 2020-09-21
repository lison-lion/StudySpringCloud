package com.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//@ServletComponentScan("com.study.hystrix.servlet")
public class CustomerApp {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApp.class, args);
	}
	
	 @Bean
	 public ServletRegistrationBean hystrixMetricsStreamServlet() {
       ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
       registration.addUrlMappings("/hystrix.stream");
       return registration;
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
