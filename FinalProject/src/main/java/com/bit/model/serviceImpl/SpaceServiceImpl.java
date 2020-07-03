package com.bit.model.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.SpaceDAO;
import com.bit.model.dto.space.DraftListDTO;
import com.bit.model.dto.space.SpaceUserInfoDTO;
import com.bit.model.service.SpaceService;

@Service("SpaceService")
public class SpaceServiceImpl implements SpaceService{
	
	@Autowired(required=false)
	SpaceDAO spaceDAO;
	

	 public SpaceUserInfoDTO getSpaceUserInfo(){
		 return spaceDAO.getSpaceUserInfo();
	 }


	@Override
	public List<DraftListDTO> getDraftList() {
		// TODO Auto-generated method stub
		return spaceDAO.getDraftList();
	}


	@Override
	public List<DraftListDTO> getMergedList() {
		// TODO Auto-generated method stub
		return spaceDAO.getMergedList();
	}


	@Override
	public List<DraftListDTO> getArchivedList() {
		// TODO Auto-generated method stub
		return spaceDAO.getArchivedList();
	}


	 
	
}
