package com.project.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest req, ServletResponse response) throws Exception {
		/*HttpServletRequest request=(HttpServletRequest)req;
		System.out.println("CustomFormAuthenticationFilter.onAccessDenied()");*/
		/*Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
    	for(Cookie cookie : cookies){
    		System.out.println(cookie.getName());
    		System.out.println(cookie.getValue());
    	}*/
    	
    	/*HttpSession session = request.getSession();
    	session.setAttribute("aaa", "aaa");*/
    	
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
