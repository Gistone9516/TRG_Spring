package com.spring.trg.domain;

public class recomlogVO {
	
	private String user_id;
	private String travel_name;
	private int list_code;
	
	public String getuser_id(){
		return user_id;
	}
	public void setuser_id(String id){
		this.user_id = id;
	}
	public String gettravel_name(){
		return travel_name;
	}
	public void settravel_name(String code){
		this.travel_name = code;
	}
	public int getlist_code(){
		return list_code;
	}
	public void setlist_code(int code){
		this.list_code = code;
	}

}
