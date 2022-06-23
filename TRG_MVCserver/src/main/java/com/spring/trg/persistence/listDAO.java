package com.spring.trg.persistence;

import java.util.List;

import com.spring.trg.domain.travel_listVO;

public interface listDAO {
	
	public void insertlist(travel_listVO vo);
	public void updatelist(travel_listVO vo);
	public void updateListRecom(travel_listVO vo);
	public void deleteList(travel_listVO vo);
	public void deleteListUser(travel_listVO vo);
	public List<travel_listVO> selectRecomlist(travel_listVO vo);
	public List<travel_listVO> selectlist(travel_listVO vo);
	public List<travel_listVO> selectUserlist(travel_listVO vo);
	public travel_listVO SelectListCode(travel_listVO vo);

}
