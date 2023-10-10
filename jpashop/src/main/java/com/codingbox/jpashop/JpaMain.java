package com.codingbox.jpashop;

import com.codingbox.jpashop.relation.Member;
import com.codingbox.jpashop.relation.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf 
			= Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Team team = new Team();
		team.setName("TeamA");
		
		//영속 상태가 되면 pk의 값이 세팅이 된 후에 영속상태 된다.
		em.persist(team);
		
		Member member = new Member();
		member.setUsername("member1");
		//member.setTeamId(team.getId());
		member.setTeam(team); // 아이디만 가져오는게 아니라 전부
		em.persist(member);
		
		
		//select
		//어떤 멤버의 pk값을 아는 상태에서 그 멤버가 어느 팀 소속인지 알고 싶을 때 확인
//		Member findMember = em.find(Member.class, member.getId()); //여기서 팀의 정보까지 다 가져온다. member정보만 가져오는게 아님. foregin 키까지 연관되어 있어서.
//		Long findTeamId = findMember.getTeamId();
//		Team findTeam = em.find(Team.class, findTeamId);
//		System.out.println("findTeam : " + findTeam.getName());
		
		//강제로 db쿼리를 보고 싶을때
		em.flush();
		em.clear();
		
		
		//어떤 멤버의 pk값을 아는 상태에서 그 멤버가 어느 팀 소속인지 알고 싶을 때 확인
		Member findMember = em.find(Member.class, member.getId()); //여기서 팀의 정보까지 다 가져온다. member정보만 가져오는게 아님. foregin 키까지 연관되어 있어서.
		Team findTeam = findMember.getTeam();  //여기서도 팀의 정보 가져옴. 아이디만 가져오는게 아니라 전부. 위에서는 id값을 가져오지만 이건 전부 다 가져온다.
		System.out.println("findTeam : " + findTeam.getName());
		
		
		tx.commit();
		
		em.close();
		emf.close();
	}

}











