package com.kosa.myapp.hr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kosa.myapp.hr.model.EmpVO;

public interface IEmpRepository {
	// 모든 사원의 수
	int getEmpCount();
	// 부서 id 사원의 수
	int getEmpCount(@Param("deptid") int deptid); //xml 문서에서 값 Mapping시 @Param 사용
	// 모든 사원의 정보
	List<EmpVO> getEmpList();
	// 사원 id 정보
	EmpVO getEmpInfo(int empid);
	// DML
	void updateEmp(EmpVO emp);
	void insertEmp(EmpVO emp);
	void deleteJobHistory(int empid); // deleteEmp 메서드 선행하여 필요
	void deleteEmp(@Param("empid") int empid, @Param("email") String email);
	// 모든 DeptId, JobId, ManagerId 조회
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();

}
