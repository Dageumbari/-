package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageGroupVO {
	private String pageGroupCode;
	private String draftCode;
	private String pageGroupName;
	private int pageGroupOrder;
}
