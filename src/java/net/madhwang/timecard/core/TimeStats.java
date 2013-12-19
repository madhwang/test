package net.madhwang.timecard.core;

import java.sql.Time;

import lombok.Data;

@Data
public class TimeStats {
	
	private Integer year;
	private Integer month;
	private Integer memberNo;
	private Integer total_record_day;
	private Time total_record_time;
}
