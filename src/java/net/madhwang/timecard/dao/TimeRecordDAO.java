package net.madhwang.timecard.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.madhwang.timecard.model.TimeRecord;
import net.madhwang.timecard.model.TimeStats;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TimeRecordDAO {
	private static final String NAME_SPACE = "net.madhwang.core.dao.TimeRecord.";

	@Resource(name = "sqlSessionTemplate")
	private SqlSession sqlSession;

	public int insertOfPunchIn(final String memberNo) {
		TimeRecord timeRecord = new TimeRecord();
		timeRecord.setMemberNo(memberNo);
		return sqlSession.insert(NAME_SPACE + "insertOfPunchIn", timeRecord);
	}

	public TimeRecord selectOneOfMemberToday(final String memberNo) {
		TimeRecord timeRecord = new TimeRecord();
		timeRecord.setMemberNo(memberNo);
		return sqlSession.selectOne(NAME_SPACE + "selectOneOfMemberToday", timeRecord);
	}

	public List<TimeRecord> selectRecordsOfMember(final int year, final int month, final String memberNo) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("yearMonth", String.format("%d%02d", year, month));
		param.put("nextYearMonth", String.format("%d%02d", year, month + 1));
		param.put("memberNo", memberNo);
		return sqlSession.selectList(NAME_SPACE + "selectRecordsOfMember", param);
	}

	public int updateOfPunchOut(final String memberNo) {
		TimeRecord timeRecord = new TimeRecord();
		timeRecord.setMemberNo(memberNo);
		return sqlSession.update(NAME_SPACE + "updateOfPunchOut", timeRecord);
	}

	public List<TimeStats> selectWorkingSecondsOfMonth(final Integer year, final Integer month) {
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("year", year.toString());
		param.put("month", month.toString());
		param.put("yearMonth", String.format("%d%02d", year, month));
		param.put("nextYearMonth", String.format("%d%02d", year, month + 1));
		return sqlSession.selectList(NAME_SPACE + "selectWorkingSecondsOfMonth", param);
	}
}