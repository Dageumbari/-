package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageTypeVO {

	/* 페이지 타입 pk */
	private String pageTypeCode;

	/* 타입 설명 */
	private String typeDescription;
}
