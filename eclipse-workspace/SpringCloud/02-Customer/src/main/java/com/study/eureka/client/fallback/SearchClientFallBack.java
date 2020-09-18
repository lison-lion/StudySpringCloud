package com.study.eureka.client.fallback;

import org.springframework.stereotype.Component;

import com.study.eureka.client.SearchClient;
import com.study.eureka.client.entiey.Customer;

@Component
public class SearchClientFallBack implements SearchClient {

	@Override
	public String search() {
		// TODO Auto-generated method stub
		return "报异常了。。。。。。。。";
	}

	@Override
	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(Integer id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer save(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

}
