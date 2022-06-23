package com.spring.trg.domain;

public class userVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private int user_age;
	private int user_gender;
	private int user_recom;
	private String user_tag1;
	private String user_tag2;
	
	
	public String getuser_id(){
		return user_id;
	}
	public void setuser_id(String id){
		this.user_id = id;
	}
	public String getuser_pw(){
		return user_pw;
	}
	public void setuser_pw(String pw){
		this.user_pw = pw;
	}
	public String getuser_name(){
		return user_name;
	}
	public void setuser_name(String name){
		this.user_name = name;
	}
	public int getuser_age(){
		return user_age;
	}
	public void setuser_age(int age){
		this.user_age = age;
	}
	public int getuser_gender(){
		return user_gender;
	}
	public void setuser_gender(int gender){
		this.user_gender = gender;
	}
	public int getuser_recom(){
		return user_recom;
	}
	public void setuser_recom(int recom){
		this.user_recom = recom;
	}
	public String getuser_tag1(){
		return user_tag1;
	}
	public void setuser_tag1(String tag){
		this.user_tag1 = tag;
	}
	public String getuser_tag2(){
		return user_tag2;
	}
	public void setuser_tag2(String tag){
		this.user_tag2 = tag;
	}
	
	
	
}
