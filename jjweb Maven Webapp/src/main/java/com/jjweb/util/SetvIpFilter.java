package com.jjweb.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SetvIpFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//HttpServletRequest req=(HttpServletRequest) request;
		//String vIp=req.getRemoteAddr();
		//req.getServletContext().setAttribute("vIp", vIp);
		String vIp=request.getRemoteAddr();
		System.out.println("1-----doFilter get user Ip1"+vIp);
		request.getServletContext().setAttribute("vIp", vIp);
		System.out.println("2insert into session--->chain.doFilter");
		
		
		
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
