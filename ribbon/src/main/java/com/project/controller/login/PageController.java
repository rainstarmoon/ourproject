package com.project.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.pojo.User;
import com.project.service.login.PageService;

@RestController
public class PageController {
	@Autowired
	private PageService pageService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		return choose(request, String.class);
	}

	@RequestMapping("/user/query")
	public Object query(HttpServletRequest request, User user) {
		return choose(request, Object.class, user);
	}

	private <T> T choose(HttpServletRequest request, Class<T> classType, Object... objects) {
		T object = null;
		String method = request.getMethod();
		switch (method.toLowerCase()) {
		case "get":
			object = pageService.getService(request, classType);
			break;
		case "post":
			object = pageService.postService(request, classType, objects);
			break;
		default:
			break;
		}
		return object;
	}

}
