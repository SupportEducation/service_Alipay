package com.server.entity;

public class news {
	private int nid;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public String getNews_time() {
		return news_time;
	}
	public void setNews_time(String news_time) {
		this.news_time = news_time;
	}
	public String getNews_clickrate() {
		return news_clickrate;
	}
	public void setNews_clickrate(String news_clickrate) {
		this.news_clickrate = news_clickrate;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	private String news_title;
	private String news_time;
	private String news_clickrate;
	private String news_content;
	private String news_img;
	public String getNews_img() {
		return news_img;
	}
	public void setNews_img(String news_img) {
		this.news_img = news_img;
	}
}
