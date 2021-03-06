package start.portfolio.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.entity.Member;
import start.portfolio.backend.service.MemberService;


@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;
	
	@PostMapping("/register")
	public Member registerMember() {
		Member setMember = memberService.createMember("chang", "1234");
		System.out.println("in");
		return setMember;
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("in");
		return "test";
	}
}
