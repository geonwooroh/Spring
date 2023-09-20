package com.codingbox.core.dto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("Member")
	public String getMember(Model model) {
		MemberDTO member = new MemberDTO(1, "자바학생", "01012345678");
		model.addAttribute("member",member);
		return "thymeleaf/member";
		
	}
}
