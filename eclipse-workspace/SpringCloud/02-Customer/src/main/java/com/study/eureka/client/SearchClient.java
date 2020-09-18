package com.study.eureka.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.eureka.client.entiey.Customer;
//import com.study.eureka.client.fallback.SearchClientFallBack;
import com.study.eureka.client.fallback.SearchClientFallBackFactory;

@FeignClient(value = "SEARCH",fallbackFactory = SearchClientFallBackFactory.class)
public interface SearchClient {
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	String search();
	
	@RequestMapping( value = "/search/{id}" ,method = RequestMethod.GET)
	Customer findById(@PathVariable(value = "id") Integer id) ;
	
	@RequestMapping( value = "/getCustomer",method = RequestMethod.GET)
	Customer findById(@RequestParam(value = "id") Integer id,@RequestParam(value = "name") String name);
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	Customer save(@RequestBody Customer cust) ;
}
