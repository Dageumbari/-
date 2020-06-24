package com.bit.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.model.dao.SpaceDAO;
import com.bit.model.dto.SpaceDTO;
import com.bit.model.dto.SpaceUserInfo;
import com.bit.model.service.SpaceService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("SpaceService")
public class SpaceServiceImpl implements SpaceService{
	
	@Autowired(required=false)
	SpaceDAO spaceDAO;
	
	
	 public List<SpaceDTO> getSpaceUserInfo(int userNo,String spaceCode){
		 log.error(spaceDAO.getSpaceUserInfo(userNo,spaceCode));
		 return spaceDAO.getSpaceUserInfo(userNo,spaceCode);
	 }

	 
	
}
