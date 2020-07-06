package com.bit.model.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InquiryVO {
	private int inqNo;
	private int userNo;
	private String inqTitle;
	private Timestamp inqDate;
	private String inqContent;
}
