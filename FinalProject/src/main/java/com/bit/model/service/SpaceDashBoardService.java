package com.bit.model.service;

import java.util.List;

import com.bit.model.dto.SpaceDashBoardDTO;
import com.bit.model.vo.GroupVO;
import com.bit.model.vo.SpaceVO;

public interface SpaceDashBoardService {
	
	//스페이스 그룹
	public List<GroupVO> getAllGroupList(String dashBoardCode);
	public void createGroup();
	public void getGorupInfo();
	public void groupNameModify();
	public void groupOrderModify();
	public void deleteGroup();
	
	//스페이스 대시보드
	public List<SpaceVO> getAllSpaceList(String groupCode);
	public void createSpace();
	//public void getSpaceInfo();
	public void spaceOrderModify();
	
}
