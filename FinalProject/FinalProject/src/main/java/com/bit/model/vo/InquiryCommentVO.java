package com.bit.model.vo;

import java.sql.Clob;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InquiryCommentVO {
	private int inqComNo;
	private int inqNo;
	private Clob inqComConetent;
	private int adminCode;
	private Timestamp inqComTime;
	
}
