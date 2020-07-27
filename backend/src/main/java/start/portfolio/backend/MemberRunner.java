package start.portfolio.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import start.portfolio.backend.entity.Member;
import start.portfolio.backend.service.MemberService;

@Component
public class MemberRunner implements ApplicationRunner {

	@Autowired
	MemberService memberService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Member member = memberService.createMember("chang", "1234");
		System.out.println("password" + member.getMemberPassword()  );
		
	}
	
}
