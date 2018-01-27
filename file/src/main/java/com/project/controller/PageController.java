package com.project.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/file")
	public String hello(Map<String, Object> map, HttpServletRequest request) {
		map.put("path", "http://"+request.getServerName() + ":" + request.getServerPort());
		return "file";
	}

}
