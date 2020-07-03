package com.bit.model.dto;

import java.sql.Clob;
import java.sql.Timestamp;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class InquiryDTO {
	
	private int inqNo;
	private String userNo;
	private String inqTitle;
	private Timestamp inqDate;
	private Clob inqContent;
	private String name;
	
}
