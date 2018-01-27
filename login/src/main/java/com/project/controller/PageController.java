package com.project.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.pojo.User;

@Controller
public class PageController {
	
	@RequestMapping("/doLogin")
	public String login(User user,HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject currentUser = SecurityUtils.getSubject();  
        try {  
            currentUser.login(token);  
        }catch(Exception e){
        	e.printStackTrace();
        }
        System.out.println("PageController.login()");
        Object attribute = request.getSession().getAttribute("aaa");
        System.out.println(attribute);
       
        
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){
        	/*
        	Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        	for(Cookie cookie : cookies){
        		System.out.println(cookie.getName());
        		System.out.println(cookie.getValue());
        	}*/
            return "redirect:/main3";
        }else{  
            token.clear();  
            return "redirect:/main2";
        } 
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		return "redirect:/main";
    }
	
	
	@RequestMapping("/main")
    public String hello(Map<String,Object> map){
       map.put("name", "没有登陆");
       return "main";
    }
	
	@RequestMapping("/main2")
    public String hello2(Map<String,Object> map){
       map.put("name", "登陆失败");
       return "main";
    }
	
	@RequestMapping("/main3")
    public String hello3(Map<String,Object> map){
       map.put("name", "登陆成功");
       return "main";
    }
	
}
