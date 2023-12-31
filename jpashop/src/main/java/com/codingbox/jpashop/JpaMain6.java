package com.codingbox.jpashop;

import java.time.LocalDateTime;
import java.util.List;

import com.codingbox.jpashop.embed.Address;
import com.codingbox.jpashop.embed.Member;
import com.codingbox.jpashop.embed.Period;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain6 {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		List<Member> result = em.createQuery(
				"select m from Member m where m.username like '%kim%'",Member.class
		).getResultList();
		
		for(Member m : result) {
			System.out.println("member: = " +m);
		}
		
		tx.commit();
		em.close();
		emf.close();
	}

}











