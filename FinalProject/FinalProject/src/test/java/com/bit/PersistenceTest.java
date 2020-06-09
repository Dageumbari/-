
package com.bit;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.model.dao.PageDAO;

public class PersistenceTest {
	@Autowired
	private PageDAO pageDAO;
	
	public void pageDAOTest() {	
		
		//System.err.println(pageDAO.getPageVO(1));
		
		System.err.println(pageDAO.getPagebyPageNo(1));		
	}

}


