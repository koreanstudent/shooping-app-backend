package start.portfolio.backend.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import start.portfolio.backend.entity.Member;
import start.portfolio.backend.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly =true) // 조회할때 이점이 됨
public class MemberService implements UserDetailsService {

	private final MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public Member createMember(String username, String password) {
		Member member = new Member(username, passwordEncoder.encode(password));
		return memberRepository.save(member);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Member> byUsername = memberRepository.findbyMemberName(username);
		Member member = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
		
		return new User(member.getMemberName(), member.getMemberPassword(), authorities());
	}

	private Collection<? extends GrantedAuthority> authorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	
}
