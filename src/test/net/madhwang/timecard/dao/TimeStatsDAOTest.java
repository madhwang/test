package net.madhwang.timecard.dao;

import javax.inject.Inject;

import net.madhwang.timecard.model.TimeStat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-root-context.xml" })
public class TimeStatsDAOTest {
	@Inject
	private TimeStatDAO timeStatDAO;

	@Test
	public void testInsert() {
		TimeStat timeStats = new TimeStat();
		timeStats.setMemberNo("1");
		timeStats.setMonth(1);
		timeStats.setYear(2006);
		timeStats.setTotalWorkingSeconds(1);
		timeStatDAO.delete(timeStats);
		timeStatDAO.insert(timeStats);

		timeStatDAO.selectYearStatsOfMember(2004, "1");

		timeStats.setTotalWorkingSeconds(4);
		timeStatDAO.update(timeStats);

	}
}