package com.study.eureka.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "OTHER-SERVICE")
public interface OtherServiceClient {
	@RequestMapping("/list")
	String list();
}
