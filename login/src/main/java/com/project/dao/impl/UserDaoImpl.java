package com.project.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.project.base.pojo.User;
import com.project.dao.UserDao;

@Repository
public class UserDaoImpl extends GenricDaoImpl implements UserDao{

	@Override
	public List<User> findByUsername(User user) {
		Query query=Query.query(Criteria.where("username").is(user.getUsername()));
		List<User> users = this.mongoTemplate.find(query, User.class);
		return users;
	}

}
