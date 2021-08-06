package com.kosa.myapp.hr.service;

import java.util.List;
import java.util.Map;

import com.kosa.myapp.hr.model.EmpVO;

public interface IEmpService {
	// 모든 사원의 수
		int getEmpCount();
		// 부서 id 사원의 수
		int getEmpCount(int deptid);
		// 모든 사원의 정보
		List<EmpVO> getEmpList();
		// 사원 id 정보
		EmpVO getEmpInfo(int empid);
		// DML
		void updateEmp(EmpVO emp);
		void insertEmp(EmpVO emp);
		void deleteEmp(int empid, String email);
		// 모든 DeptId, JobId, ManagerId 조회
		List<Map<String, Object>> getAllDeptId();
		List<Map<String, Object>> getAllJobId();
		List<Map<String, Object>> getAllManagerId();
}
