package com.spring.trg.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.trg.domain.recomlogVO;
import com.spring.trg.domain.travelVO;
import com.spring.trg.domain.travel_listVO;

@Repository
public class listDAOImpl implements listDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String Insertlist = "ListMapper.insertList";
	private static final String Updatelist = "ListMapper.updateList";
	private static final String UpdateListRecom = "ListMapper.updateListRecom";
	private static final String DeleteList = "ListMapper.deleteList";
	private static final String DeleteListUser = "ListMapper.deleteListUser";
	private static final String SelectRecomlist = "ListMapper.selectRecomList";
	private static final String Selectlist = "ListMapper.selectList";
	private static final String SelectUserlist = "ListMapper.selectUserList";
	private static final String SelectListCode = "ListMapper.selectListCode";
	
	

	
	@Override
	public void insertlist(travel_listVO vo) {
		sqlSession.insert(Insertlist,vo);
	}
	@Override
	public void updatelist(travel_listVO vo) {
		sqlSession.update(Updatelist,vo);
	}
	@Override
	public void updateListRecom(travel_listVO vo) {
		sqlSession.update(UpdateListRecom,vo);
	}
	@Override
	public void deleteList(travel_listVO vo) {
		sqlSession.delete(DeleteList,vo);
	}
	@Override
	public void deleteListUser(travel_listVO vo) {
		sqlSession.delete(DeleteListUser,vo);
	}
	@Override
	public List<travel_listVO> selectRecomlist(travel_listVO vo) {
		List<travel_listVO> returnList = new ArrayList<>();
		returnList = sqlSession.selectList(SelectRecomlist, vo);
		return returnList;
	}
	
	@Override
	public List<travel_listVO> selectlist(travel_listVO vo) {
		List<travel_listVO> returnList = new ArrayList<>();
		returnList = sqlSession.selectList(Selectlist, vo);
		return returnList;
	}
	
	@Override
	public List<travel_listVO> selectUserlist(travel_listVO vo) {
		List<travel_listVO> returnList = new ArrayList<>();
		returnList = sqlSession.selectList(SelectUserlist, vo);
		return returnList;
	}
	
	@Override
	public travel_listVO SelectListCode(travel_listVO vo) {
		return (travel_listVO)sqlSession.selectOne(SelectListCode,vo);
	}

	
	
}