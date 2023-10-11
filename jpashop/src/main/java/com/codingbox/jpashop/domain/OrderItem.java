package com.codingbox.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class OrderItem {
	
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	
	private Long id;
	
//	@Column(name="ORDER_ID")
//	
//	private Long orderId;  //이 방법 안쓰고
	
//	@Column(name="ITEM_ID")
//	private Long itemId;
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;		//이 방법으로
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private Item item;
	private int orderPrice;
	private int count;
}
