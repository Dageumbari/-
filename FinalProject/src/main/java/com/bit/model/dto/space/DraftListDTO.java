package com.bit.model.dto.space;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class DraftListDTO {
	public DraftListDTO() {}
	private String SpaceCode;
	private List<DraftDTO> DraftDTO;
}
