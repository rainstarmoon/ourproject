package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.base.config.OurProjectLog;
import com.project.dao.SysUserDao;
import com.project.pojo.SysUserPo;
import com.project.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao soysUserDao;
	
	@OurProjectLog
	@Override
	public SysUserPo querySysUserByNo(SysUserPo sysUserPo) {
		return soysUserDao.selectByNo(sysUserPo);
	}

}
