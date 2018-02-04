package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.base.config.OurProjectLog;
import com.project.pojo.SysUserPo;
import com.project.service.SysUserService;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@OurProjectLog
	@RequestMapping("/query")
	public Object query(SysUserPo sysUserPo) {
		sysUserPo = sysUserService.querySysUserByNo(sysUserPo);
		return sysUserPo;
	}
	
}
