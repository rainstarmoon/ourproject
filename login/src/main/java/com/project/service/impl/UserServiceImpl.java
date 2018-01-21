package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.po.User;
import com.project.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User queryByUsername(User user) {
		List<User> users = userDao.findByUsername(user);
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
	
}
