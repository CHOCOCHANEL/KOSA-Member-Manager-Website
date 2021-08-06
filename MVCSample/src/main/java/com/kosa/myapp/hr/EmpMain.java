package com.kosa.myapp.hr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kosa.myapp.hr.model.EmpVO;
import com.kosa.myapp.hr.service.IEmpService;

public class EmpMain {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-config.xml");
		
		IEmpService empService = context.getBean("empService", IEmpService.class);
//		
//		System.out.println("== 사원의 수 조회 == ");
//		System.out.println("사원의 수 : " + empService.getEmpCount());
//		
//		System.out.println("== 50번 부서 사원의 수 조회 == ");
//		System.out.println("50번 부서 사원 : " + empService.getEmpCount(50));
//		
//		System.out.println("== 103번 사원의 정보 조회 == ");
//		System.out.println("103번 사원 : " + empService.getEmpInfo(103));
//		
//		System.out.println("== 사원 전체 정보 조회 == ");
//		System.out.println("사원 리스트 : ");
//		List<EmpVO> empList = empService.getEmpList();
//		for(EmpVO emp : empList) {
//			System.out.println(emp);
//		}
//		
//		System.out.println("== 새로운 사원 정보 입력 == ");
//		EmpVO emp = new EmpVO();
//		emp.setEmployeeId(470);
//		emp.setFirstName("Jae");
//		emp.setLastName("Jeong");
//		emp.setEmail("Heo");
//		emp.setPhoneNumber("222-222");
//		emp.setJobId("IT_PROG");
//		emp.setSalary(8000);
//		emp.setCommissionPct(0.2);
//		emp.setManagerId(100);
//		emp.setDepartmentId(10);
//		
//		try {
//			empService.insertEmp(emp);
//			System.out.println("Inserted.");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		

		
//		System.out.println("== 470번 사원의 급여 10% 인상 ==");
//		emp470.setSalary(emp470.getSalary()*1.1);
//		empService.updateEmp(emp470);
//		System.out.println(emp470);
		
//		System.out.println("== 470번 사원의 정보 삭제하기 ==");
//		empService.deleteEmp(470, "Heo");

//		
//		System.out.println("== 모든 부서번호와 부서이름 정보 출력 ==");
//		System.out.println(empService.getAllDeptId());
//		
//		System.out.println("== 모든 직무아이디와 타이틀 정부 출력 ==");
//		System.out.println(empService.getAllJobId());
		
		System.out.println("== 모든 매니저번호와 매니저이름 출력 ==");
		System.out.println(empService.getAllManagerId());
		context.close();
	}

}
