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
	public ChattingVO(int chatNo, Timestamp msgSendTime, Timestamp msgGotTime, String chatContent, int adminCode,
			int userNo) {
		super();
		this.chatNo = chatNo;
		this.msgSendTime = msgSendTime;
		this.msgGotTime = msgGotTime;
		this.chatContent = chatContent;
		this.adminCode = adminCode;
		this.userNo = userNo;
	}
	private Timestamp msgSendTime;
	private Timestamp msgGotTime;
	private String chatContent;
	private int adminCode;
	private int userNo;
}
