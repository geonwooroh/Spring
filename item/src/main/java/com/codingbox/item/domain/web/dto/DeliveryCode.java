package com.codingbox.item.domain.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data getter setter 대신 사용한 것
//@AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 생성
//@NoArgsConstructor : 파라미터가 없는 기본 생성자를 생성
@Data				
@AllArgsConstructor
public class DeliveryCode {
	/*
	 * Fast: 빠른 배송
	 * Normal : 일반배송
	 * SLOW : 느린배송
	 */
	
	private String code;
	private String displayName;
	
}
