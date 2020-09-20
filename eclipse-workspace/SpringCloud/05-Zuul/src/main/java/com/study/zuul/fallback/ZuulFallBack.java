package com.study.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ZuulFallBack implements FallbackProvider {

	/**
	 *         *号代表针对所有服务，都走这个降级方法，提供托底数据
	 */
	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		System.out.println( "降级的服务：" + route );
		cause.printStackTrace();
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				String msg = "当前服务：" + route +"，出现问题！！！";
				return new ByteArrayInputStream(msg.getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.INTERNAL_SERVER_ERROR;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return HttpStatus.INTERNAL_SERVER_ERROR.value();
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
