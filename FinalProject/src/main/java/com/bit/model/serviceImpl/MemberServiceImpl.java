package com.bit.model.serviceImpl;

import java.util.List;

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
	public List<MemberDTO> getAllMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> getTeamList(String dashboardCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> getTeamMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

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


}
