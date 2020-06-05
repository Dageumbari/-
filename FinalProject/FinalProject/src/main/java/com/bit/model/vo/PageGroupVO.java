package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageGroupVO {

	/* 페이지 그룹 pk */
	private String pageGroupCode;

	/* 드래프트 pk */
	private String draftCode;

	/* 그룹 이름 */
	private String pageGroupName;

	/* 페이지 그룹 순서 */
	private int pageGroupOrder;
}
