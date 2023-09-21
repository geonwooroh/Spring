package com.codingbox.core2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingbox.core2.dto.Member;
import com.codingbox.core2.dto.MemberForm;
import com.codingbox.core2.service.MemberService;

@Controller
public class MemberController {
	
	//controller가 서비스에 의존한다고 표현한다. 그래서 서비스로 객체를 만든것
	//MemberService mService = new MemberService();
	
	// Service는 여러 컨트롤러에서 가져다 쓸 수 있기 때문에 
	//Spring container에 등록을 해야한다.
	//스프링의 장점을 이용해서 작업하자. 의존성 주입 작업
	private final MemberService memberService; //final은 수정 불가능하게 못 박아버리는 역할
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);   
		
		//회원가입 등록을 한 후에
		//홈 화면으로 돌린다.
		return "redirect:/";
	}
	// / members,getMapping
	//list(Model model),return "members/memberList"
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members",members);
		return "members/memberList";
	}
	
}











