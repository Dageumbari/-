package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.TeamVO;

@Mapper
public interface TeamDAO {

	public List<TeamVO> getAllTeamList(String dashBoardCode);
	
	//public void getTeamInfo();
	//public void teamNameModify();
	
	//public void createTeam();
	//public void deleteTeam();
}
