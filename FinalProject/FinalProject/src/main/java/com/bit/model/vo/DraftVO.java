package com.bit.model.vo;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DraftVO {
	private String draftCode;
	private String spaceCode;
	private Timestamp draftSavetime;
	private String draftStatus;
}
