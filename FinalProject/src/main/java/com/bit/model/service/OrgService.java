package com.bit.model.service;

import java.util.List;

import com.bit.model.vo.DashBoardVO;

public interface OrgService {
	
	public String getPersonalOrgUrl();
	public List<DashBoardVO> getAllOrgList();
	public DashBoardVO getOrgInfo(String dashBoardUrl);
	public int orgUrlCheck(String dashBoardName);
	public void createPersonalOrg();
	public void createOrg(String dashBoardName);
	public void deleteOrg(String dashBoardUrl); 
	
	//리턴자료형 설정 해야됨
	//public DashBoardVO orgNameModify(DashBoardVO dashBoardVO);
	//public DashBoardVO orgURLModify(DashBoardVO dashBoardVO);
	
	//조직 대표 이미지 업로드 변경
	//public void orgLogoModify();
}	
