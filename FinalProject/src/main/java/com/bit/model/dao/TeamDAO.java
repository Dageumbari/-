package com.bit.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeamDAO {

	//리턴 자료형, 파라미터 설정필요
	public void getAllTeamList();
	public void getTeamInfo();
	
	//public void teamNameModify();
	//public void createTeam();
	//public void deleteTeam();
}
