package com.codingbox.jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain3 {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//비영속 상태
		Member member = new Member();
		member.setId(100L);
		member.setName("100user");
		
		//영속상태
		System.out.println("-----------before---------");
		em.persist(member);//EntityManager 안에 있는 영속 컨텍스트에 관리가 된다는 뜻
		System.out.println("------------after--------");
		
//		member.setId(100L);
//		member.setName("100user");
//		
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}











