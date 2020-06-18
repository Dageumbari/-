package com.bit.model.service;

import java.util.List;

import com.bit.model.dto.MemberDTO;

public interface MemberService {
	//리턴자료형, 매개변수 설정 필요
	//팀 멤버
	public List<MemberDTO> getAllMemberList();
	public List<MemberDTO> getTeamList();
	public List<MemberDTO> getTeamMemberList();
	
	
	public void addMember();
	public void memberPermissionModify();
	public void removeOrgMember();
	public void getMemberListByPermission();
	
	//조직에 멤버 초대
	public void createUrlByPermission();
	public void revokeInviteUrl();
}
