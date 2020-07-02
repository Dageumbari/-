package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.TeamDAO;
import com.bit.model.service.TeamService;
import com.bit.model.vo.TeamVO;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDAO teamDAO;

	@Override
	public List<TeamVO> getAllTeamList(String dashBoardCode) {
		// TODO Auto-generated method stub
		return teamDAO.getAllTeamList(dashBoardCode);
	}
}