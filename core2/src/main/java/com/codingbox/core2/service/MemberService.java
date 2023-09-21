package com.codingbox.core2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingbox.core2.dto.Member;
import com.codingbox.core2.repository.MemberRepository;
import com.codingbox.core2.repository.MemoryMemberRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional 
public class MemberService {

	//서비스는 리포지토리에 의존. 그래서 리포지토리 객체를 만든다.
	//MemoryMemberRepository memberRepository = new MemoryMemberRepository();
	
	//스프링스러운 의존성 주입
	private final MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	//회원가입
	public int join(Member member) {
		memberRepository.save(member);
		return member.getId();
	}
	//전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
}
