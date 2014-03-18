package net.madhwang.timecard.dao;

import javax.inject.Inject;

import net.madhwang.timecard.model.TimeStats;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/test-root-context.xml" })
public class TimeStatsDAOTest {
	@Inject
	private TimeStatsDAO timeStatsDAO;

	@Test
	public void testInsert() {
		TimeStats timeStats = new TimeStats();
		timeStats.setMemberNo("1");
		timeStats.setMonth(1);
		timeStats.setYear(2006);
		timeStats.setTotalWorkingSeconds(1);
		timeStatsDAO.delete(timeStats);
		timeStatsDAO.insert(timeStats);

		timeStatsDAO.selectYearStatsOfMember(2004, "1");

		timeStats.setTotalWorkingSeconds(4);
		timeStatsDAO.update(timeStats);

	}
}