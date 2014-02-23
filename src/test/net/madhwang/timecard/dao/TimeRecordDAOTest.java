package net.madhwang.timecard.dao;

import javax.inject.Inject;

import net.madhwang.timecard.model.TimeRecord;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-root-context.xml" })
public class TimeRecordDAOTest {

	@Inject
	private TimeRecordDAO timeRecordDAO;

	@Test
	public void testInsertOfPunchIn() {
		String memberNo = "1";
		timeRecordDAO.insertOfPunchIn(memberNo);
		System.out.println("==" + timeRecordDAO.selectOneOfMemberToday(memberNo));
		timeRecordDAO.updateOfPunchOut(memberNo);
		TimeRecord timeRecord = timeRecordDAO.selectOneOfMemberToday(memberNo);
		System.out.println("==" + timeRecord.getStartTime());
		System.out.println("==" + timeRecordDAO.selectOneOfMemberToday(memberNo));
	}
}
