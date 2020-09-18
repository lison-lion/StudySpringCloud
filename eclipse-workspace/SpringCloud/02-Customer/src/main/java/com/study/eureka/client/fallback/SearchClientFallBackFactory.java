package com.study.eureka.client.fallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.eureka.client.SearchClient;

import feign.hystrix.FallbackFactory;

@Component
public class SearchClientFallBackFactory implements FallbackFactory<SearchClient> {

	@Autowired
	private SearchClientFallBack scf;
	
	@Override
	public SearchClient create(Throwable cause) {
		cause.printStackTrace();
		return scf;
	}

}
