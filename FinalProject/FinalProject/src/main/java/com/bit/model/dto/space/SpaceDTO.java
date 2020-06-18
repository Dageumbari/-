package com.bit.model.dto.space;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SpaceDTO {
 	private String spaceCode;
	private String groupCode;
	private String spaceName;
	private String spaceUrl;
	private int spaceOrder;
	private String spaceVisibility;
	private String teamCode;
	private String draftCode;
	private int userNo;
	public List<DraftDTO> draftDTO;
}
