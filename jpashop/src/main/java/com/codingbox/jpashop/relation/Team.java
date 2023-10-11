package com.codingbox.jpashop.relation;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Team {
	@Id
	@GeneratedValue //sequence 값 세팅
	@Column(name="TEAM_ID")
	private Long Id;
	private String name;
	
	@OneToMany(mappedBy = "team")
	private List<Member> member = new ArrayList<>(); //한 팀에 여러 멤버가 존재할 수 있기 때문
	
	public void addMember(Member member) {
		member.setTeam(this);
		this.member.add(member);
	}
	
	
}
