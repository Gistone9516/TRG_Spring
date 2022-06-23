package com.spring.trg.domain;

public class travelVO {
	
	private String travel_name;
	private String travel_tag1;
	private String travel_tag2;
	private int travel_recom;
	private String user_id;
	
	
	public String gettravel_name(){
		return travel_name;
	}
	public void settravel_name(String name){
		this.travel_name = name;
	}
	public String gettravel_tag1(){
		return travel_tag1;
	}
	public void settravel_tag1(String tag1){
		this.travel_tag1 = tag1;
	}
	public String gettravel_tag2(){
		return travel_tag2;
	}
	public void settravel_tag2(String tag2){
		this.travel_tag2 = tag2;
	}
	public int gettravel_recom(){
		return travel_recom;
	}
	public void settravel_recom(int recom){
		this.travel_recom = recom;
	}
	public String getuser_id(){
		return user_id;
	}
	public void setuser_id(String id){
		this.user_id = id;
	}
	
}
