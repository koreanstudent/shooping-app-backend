package start.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import start.portfolio.backend.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {


}
