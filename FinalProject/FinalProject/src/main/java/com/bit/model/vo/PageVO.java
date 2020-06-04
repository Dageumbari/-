package com.bit.model.vo;

import java.sql.Clob;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {
	private String pageCode;
	private String pageGroupCode;
	private String pageTypeCode;
	private String pageTitle;
	private String pageDescription;
	private Timestamp pageSavetime;
	private Clob pageConenet;
	private int pageOrder;
}
