package com.spring.trg.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.trg.domain.travelVO;
import com.spring.trg.domain.userVO;

@Repository
public class travelDAOImpl implements travelDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String InsertTravel = "TravelMapper.insertTravel";
	private static final String UpdateTravelRecom = "TravelMapper.updateTravelRecom";
	private static final String selectTravelName = "TravelMapper.selectTravelName";

	
	
	@Override
	public void insertTravel(travelVO vo) {
		sqlSession.insert(InsertTravel,vo);
	}
	@Override
	public void updateTravelRecom(travelVO vo) {
		sqlSession.update(UpdateTravelRecom,vo);
	}
	@Override
	public travelVO selectTravelName(travelVO vo) {
		return (travelVO)sqlSession.selectOne(selectTravelName,vo);
	}
}
