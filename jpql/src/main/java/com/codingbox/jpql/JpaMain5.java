package com.codingbox.jpql;

import java.util.List;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class JpaMain5 {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	
//		Member member = new Member();
//		member.setUsername("memeber1");
//		member.setAge(10);
//		em.persist(member);
		
		em.flush();
		em.clear(); //이 두 코드를 지난 후 준영속 상태
		for(int i = 1; i <= 100; i++) {
			Member member = new Member();
			member.setUsername("member" +i);
			member.setAge(i);
			em.persist(member);
			
		}
		
		//페이징 처리
		String jpql = "select m from Member m order by m.age desc";
		List<Member> resultList= em.createQuery(jpql,Member.class)
									.setFirstResult(10)
									.setMaxResults(20)
									.getResultList();
		
		System.out.println("result.size = " + resultList.size());
		for(Member m : resultList) {
			System.out.println("m : " + m.toString());
		}
		
		tx.commit();
		em.close();
		emf.close();
	}

}











