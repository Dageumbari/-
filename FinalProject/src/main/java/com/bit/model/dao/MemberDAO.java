package com.bit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bit.model.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	
	//팀 멤버
	public List<MemberDTO> getAllMemberList(String dashBoardCode);
	public List<MemberDTO> getTeamList();
	public List<MemberDTO> getTeamMemberList();
	public List<MemberDTO> getMemberListByPermission();
	
	//리턴자료형, 매개변수 설정 필요
	public void addMember();
	public void memberPermissionModify();
	public void removeOrgMember();
	
	
	//조직에 멤버 초대
	public void createUrlByPermission();
	public void revokeInviteUrl();
}
