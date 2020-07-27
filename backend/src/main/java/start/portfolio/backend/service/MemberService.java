package start.portfolio.backend.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.entity.Member;
import start.portfolio.backend.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	
	public Member createMember(String username, String password) {
		Member member = new Member(username, password);
		return memberRepository.save(member);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Member> byUsername = memberRepository.findbyUsername(username);
		Member member = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		
		return new User(member.getMemberName(), member.getMemberPassword(), authorities());
	}

	private Collection<? extends GrantedAuthority> authorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	
}
