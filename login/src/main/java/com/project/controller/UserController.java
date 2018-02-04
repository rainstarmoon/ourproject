package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.config.OurProjectLog;
import com.project.pojo.User;
import com.project.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@OurProjectLog
	@RequestMapping("/query")
	public Object query(User user) {
		user = userService.queryByUsername(user);
		return user;
	}
	
	
	
	
	
	

}
