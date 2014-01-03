package net.madhwang.timecard.core.dao;

import javax.annotation.Resource;

import net.madhwang.timecard.core.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {

	
	private static final String NAME_SPACE ="net.madhwang.core.dao.Member.";
	
	@Resource(name="sqlSessionTemplate")
	private SqlSession sqlSession;
	
	
	
	public Member selectOne(final Integer memberNo)
	{
		Member member = new Member();
		member.setMemberNo(memberNo);
		sqlSession.selectOne(NAME_SPACE+"selectOne",member);
		return member;
	}
}
