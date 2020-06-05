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
	private String editsNo;
	private String pageNo;
	private String pageTitle;
	private String pageDescription;
	private Timestamp pageSavetime;
	private Clob pageContent;
	private String pageOrder;
	private int pageParentNo;
}
