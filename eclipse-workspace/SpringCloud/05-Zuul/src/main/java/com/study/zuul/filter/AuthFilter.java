package com.study.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AuthFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		
		
		System.out.println( "----------执行校验过滤器-----------------" );
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String token = request.getParameter("token");
		
		if( token ==null || !"123".equalsIgnoreCase(token) ) {
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
		}
		
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER-2;
	}

}
