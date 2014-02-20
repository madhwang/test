package net.madhwang.timecard.model;

import lombok.Data;

@Data
public class TimeStats {

	private Integer year;
	private Integer month;
	private String memberNo;
	private Integer totalRecordHour;
}
