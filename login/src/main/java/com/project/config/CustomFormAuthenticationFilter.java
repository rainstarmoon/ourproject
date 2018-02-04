package com.project.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest req, ServletResponse response) throws Exception {
		
		/*System.out.println(request.getServerName());
		System.out.println(request.getServerPort());
		System.out.println(request.getContextPath());
		System.out.println(request.getServletPath());
		System.out.println(request.getQueryString());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());*/
		return super.onAccessDenied(req, response);
	}
	
}
