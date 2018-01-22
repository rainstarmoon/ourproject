package com.project.config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestServlet.doGet()");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestServlet.doPost()");
		super.doPost(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

}
