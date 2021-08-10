package com.team5.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.team5.myapp.hr.model.MBVO;
import com.team5.myapp.hr.service.IMBService;

public class MBMain {

	public static void main(String[] args) {
		AbstractApplicationContext context
							= new GenericXmlApplicationContext("spring/application-config.xml");
		IMBService mbService = context.getBean("MBService", IMBService.class);
		
		System.out.println("== 멤버 수 조회");
		System.out.println(mbService.getMBCount());
		System.out.println("-- 5조 멤버 수 조회");
		System.out.println(mbService.getMBCount(5));
		
		System.out.println("== 1번 멤버의 정보 조회");
		System.out.println(mbService.getMBInfo(1));
		
		System.out.println("== 사원 전체 정보 조회");
		for(MBVO mb : mbService.getMBList()) {
			System.out.println(mb);
		}
		
		context.close();
	}

}
