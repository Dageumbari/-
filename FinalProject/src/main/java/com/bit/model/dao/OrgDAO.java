package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bit.model.vo.DashBoardVO;

@Mapper
public interface OrgDAO {
	
	public String getPersonalOrgUrl(int userNo);
	public List<DashBoardVO> getAllOrgList(int userNo);
	public DashBoardVO getOrgInfo(String dashBoardUrl);
	public int orgUrlCheck(String dashBoardName);
	public void createPersonalOrg(@Param("userNo") int userNo, @Param("dashBoardName") String dashBoardName, @Param("dashBoardUrl") String dashBoardUrl);
	public void createOrg(@Param("userNo") int userNo, @Param("dashBoardName") String dashBoardName, @Param("dashBoardUrl") String dashBoardUrl);
	public void deleteOrg(String dashBoardUrl); 
	
	//리턴자료형 설정 해야됨
	public DashBoardVO orgNameModify(DashBoardVO dashBoardVO);
	public DashBoardVO orgURLModify(DashBoardVO dashBoardVO);
	
	//조직 대표 이미지 업로드 변경
	public void orgLogoModify();
}
