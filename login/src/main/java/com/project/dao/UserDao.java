package com.project.dao;

import java.util.List;

import com.project.po.User;

public interface UserDao extends GenricDao{
	
	List<User> findByUsername(User user);
	
}
