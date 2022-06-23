package com.spring.trg.persistence;

import com.spring.trg.domain.recomlogVO;
import com.spring.trg.domain.travelVO;
import com.spring.trg.domain.travel_listVO;

public interface recomlogDAO {

	public void insertRecomLog(recomlogVO vo);
	public void deleteRecomTravel(recomlogVO vo);
	public void deleteRecomList(recomlogVO vo);
	public void deleteRecomListall(recomlogVO vo);
	public recomlogVO selectRecomTravel(travelVO vo);
	public recomlogVO selectRecomList(travel_listVO vo);
	
}
