package com.codingbox.jpashop.domain;

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
public class Member {
	@Id // 키 값을 id로 설정
	@GeneratedValue	//전략 생략하면 AUTO로 세팅
	@Column(name = "MEMBER_ID")//DB입장
	private Long id; // 객체 입장
	private String name;
	private String city;
	private String street;
	private String zipcode;
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();
	
	public void addOrder(Order order) {
		order.setMember(this);
		this.orders.add(order);
	}
	
}
