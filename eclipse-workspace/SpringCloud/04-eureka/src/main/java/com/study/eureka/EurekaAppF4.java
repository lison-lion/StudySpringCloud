package com.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaAppF4 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAppF4.class, args);
	}

}
