package com.codingbox.jpql;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {
	private String username;
	private int age;
	//파라미터가 있는 생성자 만들기
	public MemberDTO(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}
	
	
	
	
}
