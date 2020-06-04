package com.bit.model.vo;

import java.sql.Clob;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InquiryVO {
	private int inquiryNo;
	private String userNo;
	private String inqTitle;
	private Timestamp inqDate;
	private Clob inqContent;
}
