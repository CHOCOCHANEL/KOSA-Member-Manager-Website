package com.kosa.myapp.hr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosa.myapp.hr.model.EmpVO;
import com.kosa.myapp.hr.service.IEmpService;

@Controller
public class EmpController {
	
	@Autowired
	IEmpService empService;

	// http://localhost:8080/myapp/hr/count 가 요청되면 
	// empCount() 메서드 실행
	@RequestMapping(value = "/hr/count")
	public String empCount(@RequestParam(value = "deptid", required = false, 
									defaultValue = "0") int deptid, Model model) {
		
		System.out.println("hr/count requested");
		
		if (deptid == 0) {
			model.addAttribute("count", empService.getEmpCount());
		} else {
			model.addAttribute("count", empService.getEmpCount(deptid));
		}
		
		return "hr/count"; // WEB-INF/views/hr/count.jsp 파일을 실행함
	}
	
	@RequestMapping(value= {"/hr", "/hr/list"})
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "hr/list";
	}
	
	@RequestMapping(value="/hr/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp", emp);
		return "hr/view";
	}
	
	/* 사원정보 입력 */
	// GET 방식(사원정보 입력 폼)과 POST 방식(입력받은 데이터 DB에 저장) 구분 처리
	
	@RequestMapping(value="/hr/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/insertform";
	}
	
	/* 사원정보 입력 처리 */
	// 사원정보 입력 폼에서 저장하면 실행됨. view로 forward하지 않고, 사원정보를 저장한 뒤, 사원목록을 redirect함.
	@RequestMapping(value="hr/insert", method=RequestMethod.POST)
	public String insertEmp(EmpVO emp, Model model) {
		empService.insertEmp(emp);
		return "redirect:/hr";
	}
	
	/* 사원정보 수정 */
	@RequestMapping(value="hr/update", method=RequestMethod.GET)
	public String updateEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/updateform";
	}
	
	/* 사원정보 수정처리 */
	// 사원정보 수정 폼에서 저장하면 실행됨. view로 forward하지 않고, 사원정보를 수정한 뒤, 사원목로를 redirect함.
	@RequestMapping(value="hr/update", method=RequestMethod.POST)
	public String updateEmp(EmpVO emp, Model model) {
		empService.updateEmp(emp);
		return "redirect:/hr/" + emp.getEmployeeId();
	//	return "redirect:/hr"; // 수정 후 사원 목록조회 화면으로 이동
	}
	
	/* 사원정보 삭제 */
	// 삭제 시 이메일 입력 요구. GET방식으로 삭제 확인을 위한 이메일 입력 폼으로 forward함.
	@RequestMapping(value="hr/delete", method=RequestMethod.GET)
	public String deleteEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		return "hr/deleteform";
	}
	
	/* 사원정보 삭제처리 */
	@RequestMapping(value="hr/delete", method=RequestMethod.POST)
	public String deleteEmp(int empid, String email, Model model) {
		empService.deleteEmp(empid, email);
		return "redirect:/hr";
	}
	
	/* 에러 처리 */
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
}
