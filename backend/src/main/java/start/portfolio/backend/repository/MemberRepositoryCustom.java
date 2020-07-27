package start.portfolio.backend.repository;

import java.util.Optional;

import start.portfolio.backend.entity.Member;

public interface MemberRepositoryCustom {

	Optional<Member> findbyMemberName(String memberName);
}
