package com.bit.model.vo;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserHistoryVO {
	private int userHistoryNo;
	private int userNo;
	private Timestamp loginDate;
}
