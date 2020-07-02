package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.vo.DashBoardVO;

@Mapper
public interface OrgDAO {

	public List<DashBoardVO> getAllOrgList();
	public DashBoardVO getOrgInfo(String dashBoardUrl);
	public void createOrg(String dashBoardName);
	
	//리턴자료형 설정 해야됨
	public void deleteOrg(); //owner이외의 멤버가 있는지 확인하고 삭제
	public DashBoardVO orgNameModify(DashBoardVO dashBoardVO);
	public DashBoardVO orgURLModify(DashBoardVO dashBoardVO);
	
	//조직 대표 이미지 업로드 변경
	public void orgLogoModify();
}
