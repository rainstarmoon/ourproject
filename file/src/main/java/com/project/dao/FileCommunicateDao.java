package com.project.dao;

import java.util.List;
import com.project.pojo.FileCommunicatePo;

public interface FileCommunicateDao {

	FileCommunicatePo insert(FileCommunicatePo fileCommunicatePo);
	
	void delete(FileCommunicatePo fileCommunicatePo);
	
	void update(FileCommunicatePo fileCommunicatePo);
	
	void updateByCondition(FileCommunicatePo fileCommunicatePo);
	
	List<FileCommunicatePo> selectByCondition(FileCommunicatePo fileCommunicatePo);
	
	FileCommunicatePo selectById(FileCommunicatePo fileCommunicatePo);
}
