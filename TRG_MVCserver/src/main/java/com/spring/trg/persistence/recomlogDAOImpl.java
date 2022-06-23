package com.spring.trg.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.trg.domain.recomlogVO;
import com.spring.trg.domain.travelVO;
import com.spring.trg.domain.travel_listVO;

@Repository
public class recomlogDAOImpl implements recomlogDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String InsertRecomLog = "RecomlogMapper.insertRecomLog";
	private static final String DeleteRecomTravel = "RecomlogMapper.deleteRecomTravel";
	private static final String DeleteRecomList = "RecomlogMapper.deleteRecomList";
	private static final String DeleteRecomListall = "RecomlogMapper.deleteRecomListall";
	private static final String SelectRecomTravel = "RecomlogMapper.selectRecomTravel";
	private static final String SelectRecomList = "RecomlogMapper.selectRecomList";

	
	@Override
	public void insertRecomLog(recomlogVO vo) {
		sqlSession.insert(InsertRecomLog,vo);
	}
	@Override
	public void deleteRecomTravel(recomlogVO vo) {
		sqlSession.delete(DeleteRecomTravel,vo);
	}
	@Override
	public void deleteRecomList(recomlogVO vo) {
		sqlSession.delete(DeleteRecomList,vo);
	}
	@Override
	public void deleteRecomListall(recomlogVO vo) {
		sqlSession.delete(DeleteRecomListall,vo);
	}
	@Override
	public recomlogVO selectRecomTravel(travelVO vo) {
		return (recomlogVO)sqlSession.selectOne(SelectRecomTravel,vo);
	}
	@Override
	public recomlogVO selectRecomList(travel_listVO vo) {
		return (recomlogVO)sqlSession.selectOne(SelectRecomList, vo);
	}
}