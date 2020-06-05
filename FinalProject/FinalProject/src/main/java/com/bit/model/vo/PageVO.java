package com.bit.model.vo;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/* 페이지 pk */
	private String pageNo;

	/* 페이지 그룹 pk */
	private String pageGroupCode;

	/* 페이지 타입 pk */
	private String pageTypeCode;

	/* 페이지 타이틀 */
	private String pageTitle;

	/* 페이지 설명 */
	private String pageDescription;

	/* 저장시간 */
	private Timestamp pageSavetime;

	/* 페이지 내용 */
	private Clob pageConenet;

	/* 페이지 순서 */
	private int pageOrder;

	/* 부모 페이지 */
	private int pageGroupNo;

	
}

