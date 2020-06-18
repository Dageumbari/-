package com.bit.model.dto.space;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DraftCard {
	
@Getter @Setter @ToString
public class DraftDTO {
	private String draftCode;
	private Timestamp draftSavetime;
	private String draftStatus;
	private String userImage;
	private String name;
	private int msgNo;
	private String msgContent;
	private int draftMsgNo;
	private int editsCount;
}
