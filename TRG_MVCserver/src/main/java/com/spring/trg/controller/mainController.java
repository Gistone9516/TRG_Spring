package com.spring.trg.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.trg.domain.ResponseVO;
import com.spring.trg.domain.recomlogVO;
import com.spring.trg.domain.travelVO;
import com.spring.trg.domain.travel_listVO;
import com.spring.trg.domain.userVO;
import com.spring.trg.persistence.listDAO;
import com.spring.trg.persistence.recomlogDAO;
import com.spring.trg.persistence.travelDAO;
import com.spring.trg.persistence.userDAO;

@Controller
public class mainController {
	
	//로그를 남겨줌
	private static final Logger logger = 
		LoggerFactory.getLogger(mainController.class);
	
	@Inject
	private userDAO userdao;
	@Inject
	private travelDAO traveldao;
	@Inject
	private listDAO listdao;
	@Inject
	private recomlogDAO recomlogdao;
	
	
	@RequestMapping("doTest")
	public @ResponseBody ResponseVO doTest() {
		ResponseVO res = new ResponseVO();
		
		res.setall("100");

		logger.info("doC 호출됨");
		return res;
	}
	
	
	////////////UserPart/////////////
	@RequestMapping("doJoin") //request - user_id, user_pw
	public @ResponseBody ResponseVO doJoin(userVO request) {
		ResponseVO res = new ResponseVO();
		userVO user = new userVO();
		
		user = userdao.selectUser(request.getuser_id());	
		try{
			if(user.getuser_id().equals("")){} //id가 존재하지 않을 경우 Null예외
			else{ //id가 존재할 경우 Id중복 예외
				res.setall("101");
			}
		}catch(NullPointerException e){
			userdao.insertUser(request);	
			res.setall("100");
		}
		return res;
	}
	@RequestMapping("doUserTag") //request - user_id, tag1, tag2
	public @ResponseBody ResponseVO doUserTag(userVO request) {
		ResponseVO res = new ResponseVO();
		userdao.updateUserTag(request);
		res.setall("110");
		return res;
	}
	@RequestMapping("doUserName") //request - user_id, user_name
	public @ResponseBody ResponseVO doUserName(userVO request) {
		ResponseVO res = new ResponseVO();
		userdao.updateUserName(request);
		res.setall("111");
		return res;
	}
	@RequestMapping("doLogin") //request - user_id, pw
	public @ResponseBody ResponseVO doLogin(userVO request) {
		ResponseVO res = new ResponseVO();
		userVO user = new userVO();
		
		user = userdao.selectUser(request.getuser_id());	
		try{
			if(user.getuser_id().equals("")){}
			else{
				if(user.getuser_pw().equals(request.getuser_pw())){
					res.setall("120");
					System.out.println(res.gettype());
				}else{
					res.setall("121");
				}
			}
		}catch(NullPointerException e){res.setall("122");}
		
		return res;
	}
	@RequestMapping("doUserDelete") //request - user_id
	public @ResponseBody ResponseVO doUserDelete(userVO request) {
		ResponseVO res = new ResponseVO();
		travel_listVO list = new travel_listVO();
		list.setuser_id(request.getuser_id());
		listdao.deleteListUser(list);
		userdao.deleteUser(request);
		res.setall("100");
		return res;
	}
	//////////////travelPart/////////////
	@RequestMapping("doInsertTravel") //request - name, tag1, tag2
	public @ResponseBody ResponseVO doInsertTravel(travelVO request) {
		ResponseVO res = new ResponseVO();
		travelVO sub = new travelVO();
		insertTravel(request);
		res.setall("100");
		return res;
	}
	public void insertTravel(travelVO request){ //name
		travelVO sub = new travelVO();
		
//		int num;
//		Random random = new Random();
//		random.setSeed(System.currentTimeMillis());
//		while(true){
//			do{
//				 num= random.nextInt(1000000);
//				}while(num < 100000);
//			try{
//				travelVO sub1 = new travelVO();
//				sub1.settravel_code(num);
//				sub = traveldao.selectTravelCode(sub1);
//				if(sub.gettravel_code() == 0){}
//				else{continue;}
//			}catch(NullPointerException e){}
//				break;
//		}
		traveldao.insertTravel(request);
	}
	@RequestMapping("doRecomAddTravel") //request - user_id, travel_name
	public @ResponseBody ResponseVO doRecomAddTravel(travelVO request) {
		ResponseVO res = new ResponseVO();
		travelVO travelsub = new travelVO();
		recomlogVO recomsub = new recomlogVO();
		
		travelsub = traveldao.selectTravelName(request);
		recomsub = recomlogdao.selectRecomTravel(request);
		try{
			if(recomsub.getuser_id().equals("")){} //추천 이력이 존재하지 않을 경우 추천 시퀀스
			else{ //추천 이력이 존재할 경우 추천 취소 시퀀스
				int i = travelsub.gettravel_recom();
				travelsub.settravel_recom(--i);
				traveldao.updateTravelRecom(travelsub);
				recomsub.setuser_id(request.getuser_id());
				recomsub.settravel_name(request.gettravel_name());
				recomlogdao.deleteRecomTravel(recomsub);
				res.setall("211");
			}
		}catch(NullPointerException e){
			int i = travelsub.gettravel_recom();
			travelsub.settravel_recom(++i);
			traveldao.updateTravelRecom(travelsub);
			recomsub.setuser_id(request.getuser_id());
			recomsub.settravel_name(request.gettravel_name());
			recomlogdao.insertRecomLog(recomsub);
			res.setall("210");
		}
		return res;
	}
	//////////////ListPart///////////////
	@RequestMapping("doInsertList") //request - city, dist, travel1~5, tag1, tag2, user_id
	public @ResponseBody ResponseVO doInsertList(travel_listVO request) {
		ResponseVO res = new ResponseVO();
		travel_listVO sub = new travel_listVO();

		int num;
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		while(true){
			do{
				 num= random.nextInt(1000000);
				}while(num < 100000);
			try{
				travel_listVO sub1 = new travel_listVO();
				sub1.setlist_code(num);
				sub = listdao.SelectListCode(sub1);
				if(sub.getlist_code() == 0){}
				else{continue;}
			}catch(NullPointerException e){}
				break;
		}
		travelMatch(request);

		sub.setlist_city(request.getlist_city());
		sub.setlist_dist(request.getlist_dist());
		
		listdao.insertlist(sub); //code, city, dist
		listdao.updatelist(request);
		res.setall("300");
		return res;
	}
	public void travelMatch(travel_listVO request){
		travelVO travelSub1 = new travelVO();
		travelVO travelSub2 = new travelVO();
		//travel1~5가 db에 이미 존재한지 확인. 만약 없다면 여행지 새로 생성, 있다면 그걸로, 그런데 이게 name으로 해줘야해
		travelSub1.settravel_name(request.getlist_travel1());
		travelSub2 = traveldao.selectTravelName(travelSub1);
		try{
			if(travelSub2.equals("")){}
			else{} //name 존재
		}catch(NullPointerException e){
			travelSub2.settravel_name(request.getlist_travel1()); //DB int -> String 변환 필요
			insertTravel(travelSub2);
			} //name 존재하지 않음
		travelSub1.settravel_name(request.getlist_travel2());
		travelSub2 = traveldao.selectTravelName(travelSub1);
		try{
			if(travelSub2.equals("")){}
			else{} 
		}catch(NullPointerException e){
			travelSub2.settravel_name(request.getlist_travel2());
			insertTravel(travelSub2);
			} 
		travelSub1.settravel_name(request.getlist_travel3());
		travelSub2 = traveldao.selectTravelName(travelSub1);
		try{
			if(travelSub2.equals("")){}
			else{} 
		}catch(NullPointerException e){
			travelSub2.settravel_name(request.getlist_travel3());
			insertTravel(travelSub2);
			}
		travelSub1.settravel_name(request.getlist_travel4());
		travelSub2 = traveldao.selectTravelName(travelSub1);
		try{
			if(travelSub2.equals("")){}
			else{} 
		}catch(NullPointerException e){
			travelSub2.settravel_name(request.getlist_travel4()); 
			insertTravel(travelSub2);
			}
		travelSub1.settravel_name(request.getlist_travel5());
		travelSub2 = traveldao.selectTravelName(travelSub1);
		try{
			if(travelSub2.equals("")){}
			else{} 
		}catch(NullPointerException e){
			travelSub2.settravel_name(request.getlist_travel5());
			insertTravel(travelSub2);
			} 
	}
	
	@RequestMapping("doDeleteList") //request - list_code, user_id
	public @ResponseBody ResponseVO doDeleteList(travel_listVO request) {
		ResponseVO res = new ResponseVO();
		recomlogVO rl = new recomlogVO();
		rl.setlist_code(request.getlist_code());
		recomlogdao.deleteRecomListall(rl);
		listdao.deleteList(request);
		res.setall("100");
		return res;
	}
	@RequestMapping("doASCList") //request - city, dist
	public @ResponseBody List<travel_listVO> doASCList(travel_listVO request) {
		List<travel_listVO> list = new ArrayList<>();
		list = listdao.selectRecomlist(request);
		return list;
	}
	@RequestMapping("doListAll") //request - city, dist
	public @ResponseBody List<travel_listVO> doListAll(travel_listVO request) {
		List<travel_listVO> list = new ArrayList<>();
		list = listdao.selectlist(request);
		return list;
	}
	@RequestMapping("doUserList") //request - user_id
	public @ResponseBody List<travel_listVO> doUserList(travel_listVO request) {
		List<travel_listVO> list = new ArrayList<>();
		list = listdao.selectUserlist(request);
		return list;
	}
	@RequestMapping("doRecomAddList") //request - user_id, list_code
	public @ResponseBody ResponseVO doRecomAddList(travel_listVO request) {
		ResponseVO res = new ResponseVO();
		travel_listVO listsub = new travel_listVO();
		recomlogVO recomsub = new recomlogVO();
		
		listsub = listdao.SelectListCode(request);
		recomsub = recomlogdao.selectRecomList(request);
		try{
			if(recomsub.getuser_id().equals("")){} //추천 이력이 존재하지 않을 경우 추천 시퀀스
			else{ //추천 이력이 존재할 경우 추천 취소 시퀀스
				int i = listsub.getlist_recom();
				listsub.setlist_recom(--i);
				listdao.updateListRecom(listsub);
				recomsub.setuser_id(request.getuser_id());
				recomsub.setlist_code(request.getlist_code());
				recomlogdao.deleteRecomList(recomsub);
				res.setall("320");
			}
		}catch(NullPointerException e){
			int i = listsub.getlist_recom();
			listsub.setlist_recom(++i);
			listdao.updateListRecom(listsub);
			recomsub.setuser_id(request.getuser_id()); 
			recomsub.setlist_code(request.getlist_code());
			recomlogdao.insertRecomLog(recomsub);
			res.setall("321");
		}
		
		return res;
	}
	
	
	
	
	
	
}
