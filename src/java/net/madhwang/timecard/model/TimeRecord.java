package net.madhwang.timecard.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

import org.apache.ibatis.type.Alias;

@Data
@Alias("timeRecord")
public class TimeRecord {

	private Date recordYmd;
	private String memberNo;
	private Timestamp startTime;
	private Timestamp endTime;

	public int getWorkingHour() {
		return (int) Math.floor((endTime.getTime() - startTime.getTime()) / 1000 / 3600);
	}

	public int getWorkingMinute() {
		return (int) Math.floor((endTime.getTime() - startTime.getTime()) / 1000 / 60 % 60);
	}

	public int getWorkingSecond() {
		return (int) ((endTime.getTime() - startTime.getTime()) / 1000) % 60;
	}
}
