package com.bit.model.vo;

import java.sql.Clob;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeVO {
	private int noticeNo;
	private String noticeTitle;
	private Date noticeDate;
	private Clob noticeContent;
	private int adminCode;
	public NoticeVO getAllNoticeInfo() {
		return new NoticeVO();
	}
}
