package com.bit.model.vo;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChattingVO {
	private int chatNo;
	private Timestamp msgSendTime;
	private Timestamp msgGotTime;
	private String chatContent;
	private int adminCode;
	private int userNo;
}
