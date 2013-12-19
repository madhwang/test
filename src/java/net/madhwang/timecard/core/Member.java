package net.madhwang.timecard.core;


import lombok.Data;

import org.apache.ibatis.type.Alias;

@Data
@Alias("member")
public class Member {
	private Integer memberNo;
	private String memberName;
}
