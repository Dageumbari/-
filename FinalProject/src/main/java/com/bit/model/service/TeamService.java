package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.TeamVO;

public interface TeamService {

	public List<TeamVO> getAllTeamList(String dashBoardCode);
}
