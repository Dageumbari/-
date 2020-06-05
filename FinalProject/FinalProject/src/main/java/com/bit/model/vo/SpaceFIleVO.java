package com.bit.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpaceFIleVO {

	/* 파일업로드 pk */
	private int fileUploadVO;

	/* 스페이스 pk */
	private String spaceCode;

	/* 파일 경로 */
	private String filePath;

}
