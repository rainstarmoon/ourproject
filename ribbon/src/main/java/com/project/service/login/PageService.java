package com.project.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PageService {

	@Autowired
	private RestTemplate restTemplate;

	public String login() {
		return restTemplate.getForObject("http://login/login", String.class);
	}

}
