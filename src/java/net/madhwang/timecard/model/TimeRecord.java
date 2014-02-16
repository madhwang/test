package net.madhwang.timecard.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class TimeRecord {

	private Date recordYmd;
	private String memberNo;
	private Timestamp startTime;
	private Timestamp endTime;
}
