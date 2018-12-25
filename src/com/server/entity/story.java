package com.server.entity;

public class story {
	private int s_id;
	private int aid;
	private String s_time;
	private String s_img;
	private String s_title;
	private String s_content;
	private String s_place;
	private int s_like;
	private String headimg;
	private String nickname;
	private int cflag;
	
	
	public int getCflag() {
		return cflag;
	}
	public void setCflag(int cflag) {
		this.cflag = cflag;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public String getS_img() {
		return s_img;
	}
	public void setS_img(String s_img) {
		this.s_img = s_img;
	}
	public String getS_title() {
		return s_title;
	}
	public void setS_title(String s_title) {
		this.s_title = s_title;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public String getS_place() {
		return s_place;
	}
	public void setS_place(String s_place) {
		this.s_place = s_place;
	}
	public int getS_like() {
		return s_like;
	}
	public void setS_like(int s_like) {
		this.s_like = s_like;
	}
	
}
