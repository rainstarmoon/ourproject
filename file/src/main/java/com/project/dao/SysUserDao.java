package com.project.dao;

import java.util.List;

import com.project.pojo.SysUserPo;

public interface SysUserDao {

	SysUserPo insert(SysUserPo sysUserPo);
	
	void delete(SysUserPo sysUserPo);
	
	void update(SysUserPo sysUserPo);
	
	void updateByCondition(SysUserPo sysUserPo);
	
	List<SysUserPo> selectByCondition(SysUserPo sysUserPo);
	
	SysUserPo selectById(SysUserPo sysUserPo);
	
}
