package com.bit.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.DashBoardVO;

@Mapper
public interface OrgDAO {

	public List<DashBoardVO> getAllOrgList();
	
	//리턴자료형 설정 해야됨
	public void getOrgInfo();
	public void craetOrg();
	public void deleteOrg();
	public void orgNameModify();
	public void orgURLModify();
	
	//조직 대표 이미지 업로드 변경
	public void orgLogoModify();
}
