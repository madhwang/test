package net.madhwang.timecard.dao;

import java.util.List;

import javax.annotation.Resource;

import net.madhwang.timecard.model.TimeStat;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TimeStatDAO {

	private static String NAME_SPACE = "net.madhwang.core.dao.TimeStats.";

	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlSession;

	public int insert(final TimeStat timeStats) {
		return sqlSession.insert(NAME_SPACE + "insert", timeStats);
	}

	public List<TimeStat> selectYearStatsOfMember(final Integer year, final String memberNo) {
		TimeStat timeStats = new TimeStat();
		timeStats.setYear(year);
		timeStats.setMemberNo(memberNo);
		return sqlSession.selectList(NAME_SPACE + "selectYearStatsOfMember", timeStats);
	}

	public int update(final TimeStat timeStats) {
		return sqlSession.update(NAME_SPACE + "update", timeStats);
	}

	public int delete(final TimeStat timeStats) {
		return sqlSession.delete(NAME_SPACE + "delete", timeStats);
	}
}