package com.codingbox.core2.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.codingbox.core2.dto.Member;

//@Repository
public class MemoryMemberRepository implements MemberRepository {

	//메모리 사용
	private static Map<Integer, Member> store = new HashMap<>(); //임시로 메모리를 db처럼 가진 것
	private static int sequence = 0;//이것도 임시
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public List<Member> findAll() {
		
		return new ArrayList<>(store.values());
	}
	
	
	
}
