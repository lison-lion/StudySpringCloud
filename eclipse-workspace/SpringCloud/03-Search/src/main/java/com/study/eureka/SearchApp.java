package com.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SearchApp {
	
	public static void main(String[] args) {
		SpringApplication.run(SearchApp.class, args);
	}
	
	/**
     * 配置路径映射，获取JSON格式的请求数据
     * @return
     */
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
//        registration.addUrlMappings("/hystrix.stream");
//        return registration;
//    }
}
