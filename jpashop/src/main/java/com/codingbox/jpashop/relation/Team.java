package com.codingbox.jpashop.relation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {
	@Id
	@GeneratedValue //sequence 값 세팅
	@Column(name="TEAM_ID")
	private Long Id;
	private String Name;
}
