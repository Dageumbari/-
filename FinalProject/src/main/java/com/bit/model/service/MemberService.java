package com.bit.model.service;

import java.util.List;

import com.bit.model.dto.MemberDTO;

public interface MemberService {
	
	//팀 멤버
	public List<MemberDTO> getAllMemberList(String dashboardCode);
	public List<MemberDTO> getTeamList(String dashboardCode);
	public List<MemberDTO> getTeamMemberList();
	public List<MemberDTO> getMemberListByPermission();
	
	public void addMember();
	public void memberPermissionModify();
	public void removeOrgMember();
	
	//조직에 멤버 초대
	public void createUrlByPermission();
	public void revokeInviteUrl();
}
