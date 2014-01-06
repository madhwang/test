package net.madhwang.timecard.model;



import lombok.Data;

import org.apache.ibatis.type.Alias;

@Alias("member")
@Data
public class Member {
	private Integer memberNo;
	private String memberName;
}
