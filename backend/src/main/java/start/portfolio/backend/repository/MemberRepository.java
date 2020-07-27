package start.portfolio.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import start.portfolio.backend.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findbyUsername(String username);

}
