package net.madhwang.timecard.batch;

import java.util.List;

import net.madhwang.timecard.dao.TimeStatsDAO;
import net.madhwang.timecard.model.TimeStats;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("timeRecordWriter")
public class TimeRecordWriter implements ItemWriter<TimeStats> {

	private TimeStatsDAO timeStatDAO;

	@Override
	public void write(final List<? extends TimeStats> timeStats) throws Exception {
		// TODO Auto-generated method stub
		for (TimeStats timeStat : timeStats) {
			timeStatDAO.insert(timeStat);
		}
	}
}
