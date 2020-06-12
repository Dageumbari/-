package com.bit.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {

	//리턴자료형, 매개변수 설정 필요
	//팀 멤버
	public void getMemberList();
	public void addMember();
	public void memberPermissionModify();
	public void removeOrgMember();
	public void getMemberListByPermission();
	
	//조직에 멤버 초대
	public void createUrlByPermission();
	public void revokeInviteUrl();
}
