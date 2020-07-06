package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageVO {

	/* 페이지 pk */
	private int pageNo;

	/* 페이지 그룹 pk */
	private String pageGroupCode;

	/* 페이지 타입 pk */
	private String pageTypeCode;

	/* 페이지 타이틀 */
	private String pageTitle;

	/* 페이지 설명 */
	private String pageDescription;

	/* 저장시간 */
	private String pageSavetime;

	/* 페이지 내용 */
	private String pageContent;

	/* 페이지 순서 */
	private int pageOrder;

	/* 부모 페이지 */
	private int pageGroupNo;
	
	/* 이전 페이지 */
	private int prev;
	
	/* 다음 페이지 */
	private int next;
}
