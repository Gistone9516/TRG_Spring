package com.spring.trg.persistence;

import com.spring.trg.domain.userVO;

public interface userDAO {
	
	public void insertUser(userVO vo);
	public void updateUserName(userVO vo);
	public void updateUserTag(userVO vo);
	public void deleteUser(userVO vo);
	public userVO selectUser(String userid);
	
}
