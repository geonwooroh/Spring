package com.codingbox.jpql;

import java.util.List;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class JpaMain3 {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
	
		Member member = new Member();
		member.setUsername("memeber1");
		member.setAge(10);
		em.persist(member);
		
		em.flush();
		em.clear(); //이 두 코드를 지난 후 준영속 상태
		
		List<Member> result = em.createQuery("select m from Member m",Member.class)
								.getResultList();	// 무조건 영속상태에 들어왔다.
		
		Member findMember = result.get(0);
		findMember.setAge(20);
		////////////////////////////////////////////
		/*
		 * jpql입장에서는 select문이 나가지만, 실제 sql입장에서는 member와 team을 조인해서 결과를 찾아야 한다. 근데 join은 실제 sql과 비슷하게 작성해야 한다.
		 */
		List<Team> result2 = em.createQuery("select m.team from Member m",Team.class)
								.getResultList();
		
		List<Team> result3 = em.createQuery("select t from Member m join m.team t",Team.class)
								.getResultList();
		/////////////////////////////////////////////////////////
		em.createQuery("select o.address from Order o",Address.class)
		  .getResultList();
		//embeded로 가져오기 때문에 컬럼3개 다 가져온다.
		
//		em.createQuery("select o.address from Address o",Address.class)
//		.getResultList(); //이건 불가능 . Order에서 가지고 와야 함 엔티티에서 가지고 오는 건데 address는 엔티티 설정(어노테이션) 안해줘서 불가
		
		em.createQuery("select distinct m.username, m.age from Member m")
			.getResultList();
		
		tx.commit();
		em.close();
		emf.close();
	}

}











