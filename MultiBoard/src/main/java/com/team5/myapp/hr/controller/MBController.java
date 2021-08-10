package com.team5.myapp.hr.controller;

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

import com.team5.myapp.hr.model.MBVO;
import com.team5.myapp.hr.model.gHistoryVO;
import com.team5.myapp.hr.service.IMBService;

@Controller
public class MBController {
	
	@Autowired
	IMBService mbService;

	@RequestMapping(value="hr/count")
	public String MBCount(@RequestParam(value="groupid", required=false, defaultValue="0") int groupid, Model model) {
		if(groupid==0) {
			model.addAttribute("count", mbService.getMBCount());
		} else {
			model.addAttribute("count", mbService.getMBCount(groupid));
		}
		return "hr/count";
	}

	/* Member 전체 목록 조회 */
	@RequestMapping(value= {"/hr", "/hr/list"})
	public String getAllMBs(@RequestParam(value="groupid", required=false, defaultValue="0") int groupid, Model model) {
		if(groupid==0) model.addAttribute("count", mbService.getMBCount());
		else model.addAttribute("count", mbService.getMBCount(groupid));
		List<MBVO> mbList = mbService.getMBList();
		model.addAttribute("mbList", mbList);
		return "hr/list";
	}
	
	@RequestMapping(value="/hr/{mbid}")
	public String getMBInfo(@PathVariable int mbid, Model model) {
		MBVO mb = mbService.getMBInfo(mbid);
		model.addAttribute("mb", mb);
		return "hr/view";
	}
	
	/* 구성원정보 입력 */
	// GET 방식(사원정보 입력 폼)과 POST 방식(입력받은 데이터 DB에 저장) 구분 처리
	@RequestMapping(value="/hr/insert", method=RequestMethod.GET)
	public String insertMB(Model model) {
		model.addAttribute("jobList", mbService.getAllJobId());
		model.addAttribute("groupList", mbService.getAllGroupId());
		model.addAttribute("managerList", mbService.getAllManagerId());
		return "hr/insertform";
	}
	
	/* 구성원 정보 입력 처리 */
	// 사원정보 입력 폼에서 저장하면 실행됨. view로 forward하지 않고, 사원정보를 저장한 뒤, 사원목록을 redirect함.
	@RequestMapping(value="/hr/insert", method=RequestMethod.POST)
	public String insertMB(MBVO mb, Model model) {
		mbService.insertMB(mb);
		return "redirect:/hr";
	}
	
	/* 구성원 정보 수정 */
	@RequestMapping(value="/hr/update", method=RequestMethod.GET)
	public String updateMB(int mbid, Model model){
		System.out.println("aa");
		model.addAttribute("mb", mbService.getMBInfo(mbid));
		model.addAttribute("jobList", mbService.getAllJobId());
		model.addAttribute("groupList", mbService.getAllGroupId());
		model.addAttribute("managerList", mbService.getAllManagerId());
		return "hr/updateform";
	}
	
	/* 구성원 정보 수정처리 */
	// 사원정보 수정 폼에서 저장하면 실행됨. view로 forward하지 않고, 사원정보를 수정한 뒤, 사원목로를 redirect함.
	@RequestMapping(value="hr/update", method=RequestMethod.POST)
	public String updateMB(MBVO mb, Model model) {
		mbService.updateMB(mb);
		return "redirect:/hr";
	//	return "redirect:/hr"; // 수정 후 사원 목록조회 화면으로 이동
	}
}