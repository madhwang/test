package net.madhwang.timecard.dao;

import java.util.List;

import javax.annotation.Resource;

import net.madhwang.timecard.model.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	private static final String NAME_SPACE = "net.madhwang.core.dao.Member.";

	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlSession;

	public void insert(final Member member) {
		sqlSession.insert(NAME_SPACE + "insert", member);
	}
	
	public void update(final String memberNo, final String memberName, final String memberPassword) {
		Member member = new Member();
		member.setMemberNo(memberNo);
		member.setMemberName(memberName);
		member.setMemberPassword(memberPassword);
		sqlSession.insert(NAME_SPACE + "update", member);
	}
	
	public void delete(final String memberNo) {
		Member member = new Member();
		member.setMemberNo(memberNo);
		sqlSession.insert(NAME_SPACE + "delete", member);
	}


	public Member selectOneByMemberNo(final String memberNo) {
		Member member = new Member();
		member.setMemberNo(memberNo);
		return sqlSession.selectOne(NAME_SPACE + "selectOneByMemberNo", member);
	}
	
	public List<Member> selectListWithRecordTime(final int startRowNum) {
		return sqlSession.selectList(NAME_SPACE + "selectListWithRecordTime", startRowNum);
	}
}