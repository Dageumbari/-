package com.bit.model.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EditsCommentVO {
	private int commentNo;
	private String editsCode;
	private String commentContent;
	private Timestamp commentTime;
}
