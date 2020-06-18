package com.bit.model.dto.space;

import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DraftCardList {
	private String spaceCode;
	private String draftCode;
	private int userNo;
	private String name;
	private Timestamp draftSavetime;
	private List<DraftCardList> draftCards;
}