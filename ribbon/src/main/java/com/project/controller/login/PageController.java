package com.project.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.login.PageService;

@RestController
public class PageController {
	@Autowired
	private PageService pageService;

	@RequestMapping("/loadBalancedlogin")
	public String login(HttpServletRequest request) {
		return pageService.login();
	}

}
