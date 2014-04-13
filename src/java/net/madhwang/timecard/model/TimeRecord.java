package net.madhwang.timecard.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
		return (int) Math.floor((this.endTime.getTime() - this.startTime.getTime()) / 1000 / 3600);
	}

	public int getWorkingMinute() {
		return (int) Math.floor((this.endTime.getTime() - this.startTime.getTime()) / 1000 / 60 % 60);
	}

	public int getWorkingSecond() {
		return (int) ((this.endTime.getTime() - this.startTime.getTime()) / 1000) % 60;
	}

	public String getStartDayTime() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(this.startTime.getTime());
	}

	public String getEndDayTime() {
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(this.endTime.getTime());
	}

}
