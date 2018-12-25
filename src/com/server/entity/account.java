package com.server.entity;

public class account {
	private int aid;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAflat() {
		return aflat;
	}
	public void setAflat(int aflat) {
		this.aflat = aflat;
	}
	private String password;
	private int aflat;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
	private String headimg;
	private String nickname;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
	
}
