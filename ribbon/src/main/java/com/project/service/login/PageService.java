package com.project.service.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.project.base.pojo.User;

@Service
public class PageService {

	@Autowired
	private RestTemplate restTemplate;

	public <T> T getService(HttpServletRequest request, Class<T> classType) {
		String name = "http://login" + request.getRequestURI() + "?" + request.getQueryString();
		return restTemplate.getForObject(name, classType);
	}

	public <T> T postService(HttpServletRequest request, Class<T> classType, Object... objects) {
		String name = "http://login" + request.getRequestURI();
		
		MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
		
		postParameters.add("username", "xiazeyu");
		
		return restTemplate.postForObject(name, postParameters, classType);
	}

}
