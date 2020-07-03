package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.SpaceDashBoardDAO;
import com.bit.model.dto.SpaceDashBoardDTO;
import com.bit.model.service.SpaceDashBoardService;
import com.bit.model.vo.GroupVO;
import com.bit.model.vo.SpaceVO;

@Service
public class SpaceDashBoardServiceImpl implements SpaceDashBoardService {

	@Autowired
	SpaceDashBoardDAO spaceDashBoardDAO;
	
	public SpaceDashBoardServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<GroupVO> getAllGroupList(String dashBoardCode) {
		
		return spaceDashBoardDAO.getAllGroupList(dashBoardCode);
	}

	@Override
	public void createGroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getGorupInfo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupNameModify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupOrderModify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SpaceVO> getAllSpaceList(String groupCode) {
		
		return spaceDashBoardDAO.getAllSpaceList(groupCode);
	}

	@Override
	public void createSpace() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void spaceOrderModify() {
		// TODO Auto-generated method stub
		
	}

}
