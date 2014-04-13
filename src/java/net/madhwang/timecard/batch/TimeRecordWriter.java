package net.madhwang.timecard.batch;

import java.util.List;

import net.madhwang.timecard.dao.TimeStatDAO;
import net.madhwang.timecard.model.TimeStat;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("timeRecordWriter")
public class TimeRecordWriter implements ItemWriter<TimeStat> {

	private TimeStatDAO timeStatDAO;

	@Override
	public void write(final List<? extends TimeStat> timeStats) throws Exception {
		// TODO Auto-generated method stub
		for (TimeStat timeStat : timeStats) {
			timeStatDAO.insert(timeStat);
		}
	}
}
