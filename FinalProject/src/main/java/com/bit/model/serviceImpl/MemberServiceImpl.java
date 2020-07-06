package com.bit.model.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.MemberDAO;
import com.bit.model.dto.MemberDTO;
import com.bit.model.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public List<MemberDTO> getAllMemberList(String dashBoardCode) {
		// TODO Auto-generated method stub
		return memberDAO.getAllMemberList(dashBoardCode);
	}
	
	/*
	 * @Override public List<MemberDTO> getTeamList(String dashBoardCode) { // TODO
	 * Auto-generated method stub return memberDAO.getTeamList(dashBoardCode); }
	 */

	@Override
	public List<MemberDTO> getMemberListByPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberPermissionModify() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrgMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUrlByPermission() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void revokeInviteUrl() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberDTO> getAllMembers(String dashBoardCode) {
		// TODO Auto-generated method stub
		return memberDAO.getAllMembers(dashBoardCode);
	}

	@Override
	public int getAllMemberCnt(String DashBoardCode) {
		// TODO Auto-generated method stub
		return memberDAO.getAllMemberCnt(DashBoardCode);
	}


}
