package com.bit.model.vo;

import java.sql.Clob;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditsVO {
	private String editsCode;
	private String pageCode;
	private String pageTitle;
	private String pageDescription;
	private Timestamp pageSavetime;
	private Clob pageContent;
	private String pageOrder;
}
