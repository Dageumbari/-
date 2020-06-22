package com.bit.model.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("noticeCriteria")
public class NoticeCriteriaDTO {
	private int pageNo;
	private int noticeAmount;
	
	public NoticeCriteriaDTO() {
		this(1,10);
	}
	
	public NoticeCriteriaDTO(int pageNo, int noticeAmount) {
		super();
		this.pageNo = pageNo;
		this.noticeAmount = noticeAmount;
	}
}
