package com.codingbox.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain4 {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// 비영속 상태
		Member2 member = new Member2();
		//member.setId("ID_A");
		member.setUsername("JPA_A");
		
		
		//영속상태로 넘어감
		em.persist(member);
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}











