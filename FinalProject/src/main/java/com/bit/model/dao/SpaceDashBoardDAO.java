package com.bit.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpaceDashBoardDAO {

	//리턴자료형, 매개변수 설정 필요
	//그룹
	public void getAllGroupList();
	public void createGroup();
	public void getgroupInfo();
	public void groupNameModify();
	public void groupOrderModify();
	public void deleteGroup();
	
	
	//스페이스 대시보드
	public void getAllSpaceList();
	public void createSpace();
	public void getSpaceInfo();
	public void spaceInfoModify();
	public void spaceOrderModify();
	public void deleteSpace();
	
}
