package com.bit.model.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.OrgDAO;
import com.bit.model.dto.MemberDTO;
import com.bit.model.service.OrgService;
import com.bit.model.vo.DashBoardVO;
import com.bit.security.SessionUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrgServiceImpl implements OrgService {
	
	@Autowired
	OrgDAO orgDAO;
	
	@Autowired
	HttpSession httpSession;
	
	public int currentUserNo() {
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute("sessionUser");
		int userNo = sessionUser.getUserNo();

		return userNo;
	}
	
	public OrgServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<DashBoardVO> getAllOrgList() {
		int userNo = currentUserNo();	
		
		return orgDAO.getAllOrgList(userNo);
	}

	@Override
	public DashBoardVO getOrgInfo(String dashBoardUrl) {
		// TODO Auto-generated method stub
		return orgDAO.getOrgInfo(dashBoardUrl);
	}

	@Override
	public int orgUrlCheck(String dashBoardName) {
		System.out.println("========>서비스단에서 조직URL 중복 체크");
		int result = orgDAO.orgUrlCheck(dashBoardName);
		
		return result;
	}

	@Override
	public void createPersonalOrg() {
		int userNo = currentUserNo();
		
		SessionUser sessionUser = (SessionUser) httpSession.getAttribute("sessionUser");
		String dashBoardName =  sessionUser.getName();
		int result = orgUrlCheck(dashBoardName);
		
		String dashBoardUrl = "";
		if (result > 0) {
			dashBoardUrl = dashBoardName+"-"+(result++);
		}else if(result == 0){
			dashBoardUrl = dashBoardName;
		}
		
		orgDAO.createPersonalOrg(userNo, dashBoardName, dashBoardUrl);
	}

	@Override
	public void createOrg(String dashBoardName) {
		int userNo = currentUserNo();	
		int result = orgUrlCheck(dashBoardName);
		String dashBoardUrl = "";
		
		if (result > 0) {
			dashBoardUrl = dashBoardName+"-"+(++result);
		}else if(result == 0){
			dashBoardUrl = dashBoardName;
		}

		orgDAO.createOrg(userNo, dashBoardName, dashBoardUrl);
	}

	@Override
	public void deleteOrg(String dashBoardUrl) {
		orgDAO.deleteOrg(dashBoardUrl);
	}

	@Override
	public String getPersonalOrgUrl() {
		int userNo = currentUserNo();
		
		return orgDAO.getPersonalOrgUrl(userNo);
	}

}
