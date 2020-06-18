package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.SpaceDAO;
import com.bit.model.dto.space.DraftCard;
import com.bit.model.dto.space.SpaceUserInfoDTO;
import com.bit.model.service.SpaceService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("SpaceService")
public class SpaceServiceImpl implements SpaceService{
	
	@Autowired(required=false)
	SpaceDAO spaceDAO;
	
	
	
	 public List<SpaceUserInfoDTO> getSpaceUserInfo(int userNo,String spaceCode){
		 return spaceDAO.getSpaceUserInfo(userNo,spaceCode);
	 }



	@Override
	public List<DraftCard> getSavedDraft() {
		// TODO Auto-generated method stub
		return spaceDAO.getdraftList();
	}
	 
	
}
