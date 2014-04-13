package net.madhwang.timecard.batch;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import net.madhwang.timecard.dao.TimeRecordDAO;
import net.madhwang.timecard.model.TimeStat;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("timeRecordReader")
public class TimeRecordReader implements ItemReader<List<TimeStat>> {

	@Inject
	private TimeRecordDAO timeRecordDAO;

	@Override
	public List<TimeStat> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		Calendar nowDate = Calendar.getInstance();
		int year = nowDate.get(Calendar.YEAR);
		int month = nowDate.get(Calendar.MONTH) + 1;
		List<TimeStat> timeStats = timeRecordDAO.selectWorkingSecondsOfMonth(year, month);
		return timeStats;
	}
}