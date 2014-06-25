package net.madhwang.timecard.dao;

import java.util.List;

import javax.annotation.Resource;

import net.madhwang.timecard.model.TimeStats;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TimeStatsDAO {

	private static String NAME_SPACE = "net.madhwang.core.dao.TimeStats.";

	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlSession;

	public int insert(final TimeStats timeStats) {
		return sqlSession.insert(NAME_SPACE + "insert", timeStats);
	}

	public List<TimeStats> selectYearStatsOfMember(final Integer year, final String memberNo) {
		TimeStats timeStats = new TimeStats();
		timeStats.setYear(year);
		timeStats.setMemberNo(memberNo);
		return sqlSession.selectList(NAME_SPACE + "selectYearStatsOfMember", timeStats);
	}

	public int update(final TimeStats timeStats) {
		return sqlSession.update(NAME_SPACE + "update", timeStats);
	}

	public int delete(final TimeStats timeStats) {
		return sqlSession.delete(NAME_SPACE + "delete", timeStats);
	}
}