package com.spring.trg.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.trg.domain.userVO;

@Repository
public class userDAOImpl implements userDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String InsertUser = "UserMapper.insertUser";
	private static final String UpdateUserName = "UserMapper.updateUserName";
	private static final String UpdateUserTag = "UserMapper.updateUserTag";
	private static final String deleteUser = "UserMapper.deleteUser";
	private static final String SelectUser = "UserMapper.selectUser";
	
	
	@Override
	public void insertUser(userVO vo) {
		sqlSession.insert(InsertUser,vo);
	}
	@Override
	public void updateUserName(userVO vo) {
		sqlSession.update(UpdateUserName,vo);
	}
	@Override
	public void updateUserTag(userVO vo) {
		sqlSession.update(UpdateUserTag,vo);
	}
	@Override
	public void deleteUser(userVO vo) {
		sqlSession.delete(deleteUser,vo);
	}
	@Override
	public userVO selectUser(String userid) {
		return (userVO)sqlSession.selectOne(SelectUser,userid);
	}
}
