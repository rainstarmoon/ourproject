package com.project.dao;

import java.util.List;

import com.project.pojo.User;

public interface UserDao extends GenricDao{
	
	List<User> findByUsername(User user);
	
}
