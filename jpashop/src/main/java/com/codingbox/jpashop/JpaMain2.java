package com.codingbox.jpashop;

import java.util.List;

import com.codingbox.jpashop.relation.Member;
import com.codingbox.jpashop.relation.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain2 {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
//		//양방향 매핑 시에 가장 많이 하는 실수
//		Member member = new Member();
//		member.setUsername("member1");
//		em.persist(member);
//		
//		Team team = new Team();
//		team.setName("TeamA");
//		team.getMember().add(member);
//		em.persist(team);
		
		
		//수정
		Team team = new Team();
		team.setName("TeamB");
		em.persist(team);//영속상태 만들기 db에 들어간다고 생각하자
		
		Member member = new Member();
		member.setUsername("member2");
		//member.setTeam(team); //연관관계 주인에게 값 설정
		//member.changeTeam(team); //N에 넣기. Team에 메서드가 설정되어 있다.
		em.persist(member); // 영속상태 만들기
		
		team.addMember(member);	// 1에 넣기
		
		//team.getMember().add(member); //양쪽에 모두 값을 넣어야 한다. 값을 세팅하는 부분. 1차캐시에 넣는 과정
		
		//em.flush();,em.clear();를 주석처리한다는 건 영속성 컨텍스트를 사용하겠다.
//		em.flush();
//		em.clear();
		
		System.out.println("-----------------");
		Team findTeam = em.find(Team.class, team.getId());
		List<Member> members = findTeam.getMember();
		
		for(Member m : members) {
			System.out.println("m = " + m.getUsername());
		}
		
		System.out.println("---------------------");
		
		
		tx.commit();
		em.close();
		emf.close();
	}

}











