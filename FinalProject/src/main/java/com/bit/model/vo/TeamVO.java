package com.bit.model.vo;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.model.dto.MemberDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamVO {
	private String teamCode;
	private String DashboardCode;
	private String teamName;
	
	@Autowired(required = false)
	private MemberDTO memPermit;
	
}
