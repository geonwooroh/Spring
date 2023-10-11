package com.codingbox.jpashop.embed;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
public class Address {
	private String city;
	private String street;
	private String zipcode;
	
	//테스트를 위해 파라미터가 있는 생성자
	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
	public Address() {}
	
	//setter를 없앤다
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}
	
}
