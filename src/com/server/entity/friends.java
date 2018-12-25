package com.server.entity;

public class friends {
	private String headimg;
	private String nickname;
	private int teasum;
	private int fansum;
	private int aaid;
	//别人是否关注了我
	private int flag;
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getAaid() {
		return aaid;
	}
	public void setAaid(int aaid) {
		this.aaid = aaid;
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
	public int getTeasum() {
		return teasum;
	}
	public void setTeasum(int teasum) {
		this.teasum = teasum;
	}
	public int getFansum() {
		return fansum;
	}
	public void setFansum(int fansum) {
		this.fansum = fansum;
	}
	
}
