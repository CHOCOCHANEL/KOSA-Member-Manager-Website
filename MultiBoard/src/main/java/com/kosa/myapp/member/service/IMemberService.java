package com.kosa.myapp.member.service;

import java.util.List;

import com.kosa.myapp.member.model.Member;

// IMemberService는 회원 관리 서비스 메서드를 정의한 인터페이스
public interface IMemberService {
	void insertMember(Member member);
	Member selectMember(String userid);
	List<Member> selectAllMembers();
	void updateMember(Member member);
	void deleteMember(Member member);
	String getPassword(String userid);
}
