package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.SpaceVO;

public interface SpaceDashBoardService {
	
	//스페이스 그룹
	public void getAllGroupList();
	public void createGroup();
	public void getGorupInfo();
	public void groupNameModify();
	public void groupOrderModify();
	public void deleteGroup();
	
	//스페이스
	public List<SpaceVO> getAllSpaceList();
	public void spaceOrderModify();
	//public void createSpace();
	//public void getSpaceInfo;
	//public void spaceInfoModify();
}
