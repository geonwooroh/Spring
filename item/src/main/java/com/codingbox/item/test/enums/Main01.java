package com.codingbox.item.test.enums;

public class Main01 {

	public static void main(String[] args) {
		Week today = Week.FRIDAY;
		System.out.println(today);
		
		Week.MONDAY.dayInfo();
		Week.FRIDAY.dayInfo();
	}
}
