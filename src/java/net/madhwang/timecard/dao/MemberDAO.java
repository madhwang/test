package net.madhwang.timecard.dao;

import javax.annotation.Resource;

import net.madhwang.timecard.model.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	private static final String NAME_SPACE = "net.madhwang.core.dao.Member.";

	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlSession;

	public Member selectOne(final String memberNo) {
		Member member = new Member();
		member.setMemberNo(memberNo);
		return sqlSession.selectOne(NAME_SPACE + "selectOne", member);
	}
}
