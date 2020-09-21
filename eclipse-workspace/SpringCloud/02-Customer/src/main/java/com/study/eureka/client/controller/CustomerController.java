package com.study.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesCommandDefault;
import com.study.eureka.client.OtherServiceClient;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.EurekaClient;
import com.study.eureka.client.SearchClient;
import com.study.eureka.client.entiey.Customer;

@RestController
public class CustomerController {
//	@Autowired
//	private RestTemplate temp;
	
//	@Autowired
//	private EurekaClient client;
	
	@Value("${version}")
	private String version;
	
	@Autowired
	private OtherServiceClient osclient;
	
	@GetMapping("/list")
	public String list() {
		return osclient.list();
	}
	
	@GetMapping("/version")
	public String version() throws InterruptedException {
//		Thread.sleep(3000);该代码为了测试Zuul降级测试而写
		return version;
	}
	
	@Autowired
	private SearchClient srClient;
	
	@GetMapping("/customer")
	public String customer() {
//		//通过client获取到search的服务信息
//		InstanceInfo info = client.getNextServerFromEureka("SEARCH", false);
//		//获取到访问地址
//		String url = info.getHomePageUrl();
//		System.out.println( "url--------" + url );
//		
//		String result = temp.getForObject(url+"/search", String.class);
		
//		String result = temp.getForObject("http://SEARCH/search", String.class);
		
		String result = srClient.search();
		
		return result;
	}
	
	@GetMapping( "/search/{id}" )
	@HystrixCommand(fallbackMethod = "findByIdFallBack")
	public Customer findById(@PathVariable Integer id) {
		return srClient.findById(id);
	}
	
	public Customer findByIdFallBack(@PathVariable Integer id) {
		return new Customer(-1, "", 0);
	}
	
	@GetMapping("/getCustomer")
	public Customer findById(@RequestParam Integer id,@RequestParam String name) {
		return srClient.findById(id, name);
	}
	
	@GetMapping("/save")
	public Customer save(Customer cust) {
		return srClient.save(cust);
	}
}
