package com.study.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApp {
	
		public static void main(String[] args) {
			SpringApplication.run(ZuulApp.class, args);
		}
		
		@Bean
		public PatternServiceRouteMapper serviceRouteMapper() {
		    return new PatternServiceRouteMapper(
		        "(?<name>^.+)-(?<version>v.+$)",
		        "${version}/${name}");
		}
}
