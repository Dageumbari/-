package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.bit.model.dto.SpaceDashBoardDTO;
import com.bit.model.vo.GroupVO;
import com.bit.model.vo.SpaceVO;

@Mapper
public interface SpaceDashBoardDAO {

	//스페이스 그룹
	public List<GroupVO> getAllGroupList(String dashBoardCode);
	public void createGroup();
	public void getgroupInfo();
	public void groupNameModify();
	public void groupOrderModify();
	public void deleteGroup();
	
	//스페이스 대시보드
	public List<SpaceVO> getAllSpaceList(String groupCode);
	public void createSpace();
	//public void getSpaceInfo();
	public void spaceOrderModify();
		
}
