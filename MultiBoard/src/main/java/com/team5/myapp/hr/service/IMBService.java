package com.team5.myapp.hr.service;

import java.util.List;
import java.util.Map;

import com.team5.myapp.hr.model.MBVO;

public interface IMBService {
	

	int getMBVOCount();
	int getMBVOCount(int groupId);//그룹별 숫자 조회
	List<MBVO> getMBList();
	MBVO getMBInfo(int memid);
	void updateMB(MBVO mb);
	void insertMB(MBVO mb);
	void deleteMB(int memid, String email);
	List<Map<String, Object>> getAllGroupId();
	//List<Map<String, Object>> getAllManagerId();
	List<Map<String,Object>> getAllJobId();

}
