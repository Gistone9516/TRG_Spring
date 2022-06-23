package com.spring.trg.persistence;

import com.spring.trg.domain.travelVO;

public interface travelDAO {
	
	public void insertTravel(travelVO vo);
	public void updateTravelRecom(travelVO vo);
	public travelVO selectTravelName(travelVO vo);
	
}
