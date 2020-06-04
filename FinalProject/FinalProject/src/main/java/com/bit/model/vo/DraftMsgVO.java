package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DraftMsgVO {
	private int msgNo;
	private String msgContent;
	private int editsCount;
	private String draftCode;
}
