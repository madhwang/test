package net.madhwang.timecard.model;

import java.sql.Time;

import lombok.Data;

@Data 
public class TimeRecord {

	private String recordYmd;
	private Integer memberNo;
	private Time startTime;
	private Time endTime;
	private Time timeTerm;

}
