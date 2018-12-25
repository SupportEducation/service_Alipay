package com.server.entity;

public class teaexprience {
	private int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getOrganizationname() {
		return organizationname;
	}
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public String getTeaplace() {
		return teaplace;
	}
	public void setTeaplace(String teaplace) {
		this.teaplace = teaplace;
	}
	public String getTeadescribe() {
		return teadescribe;
	}
	public void setTeadescribe(String teadescribe) {
		this.teadescribe = teadescribe;
	}
	private String organizationname;
	private String activityname;
	private String teaplace;
	private String teadescribe;
}
