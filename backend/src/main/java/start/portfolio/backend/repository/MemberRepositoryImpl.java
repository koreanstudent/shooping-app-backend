package start.portfolio.backend.repository;

import static start.portfolio.backend.entity.QMember.member;

import java.util.Optional;

import javax.persistence.EntityManager;

import com.querydsl.jpa.impl.JPAQueryFactory;

import start.portfolio.backend.entity.Member;

public class MemberRepositoryImpl implements MemberRepositoryCustom{

	private final JPAQueryFactory queryFactory;
	
	public MemberRepositoryImpl(EntityManager em) {
		this.queryFactory = new JPAQueryFactory(em);
	}

	@Override
	public Optional<Member> findbyMemberName(String memberName) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(queryFactory
				.selectFrom(member)
				.where(member.memberName.eq(memberName))
				.fetchOne());
	}


	

}
