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
	
	public ChattingVO() {
	}
	public ChattingVO(int chatNo, String chatContent, int adminCode, int userNo )
	{
		this.chatNo = chatNo;
		this.chatContent = chatContent;
		this.adminCode = adminCode;
		this.userNo = userNo;
		this.msgGotTime=msgGotTime;
		this.msgSendTime=msgSendTime;
	}
}
