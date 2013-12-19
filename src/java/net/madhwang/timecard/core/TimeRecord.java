package net.madhwang.timecard.core;

import java.sql.Time;
import java.util.Date;

import lombok.Data;

@Data 
public class TimeRecord {

	private String recordYmd;
	private Integer memberNo;
	private Time startTime;
	private Time endTime;
	private Time timeTerm;

}
