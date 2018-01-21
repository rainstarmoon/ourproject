package com.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.project.dao.GenricDao;

@Repository
public class GenricDaoImpl implements GenricDao{
	@Autowired  
	public MongoTemplate mongoTemplate; 
}
