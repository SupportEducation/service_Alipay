package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.server.entity.eduexp;
import com.server.entity.teaexprience;
import com.server.util.DBUtil;

public class teaexprienceDao {
	DBUtil util = new DBUtil();
	
	public teaexprience getOneteae(int  uid) {
		String sql = "select * from teasupport.teaexprience where userid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,uid);
			 
			ResultSet rs = pstmt.executeQuery();
			teaexprience teae=new teaexprience();
			while (rs.next()) {
				teae.setUserid(rs.getInt(1));
				teae.setOrganizationname(rs.getString(2));
				teae.setActivityname(rs.getString(3));
				teae.setTeaplace(rs.getString(4));
				teae.setTeadescribe(rs.getString(5));
			}
			conn.close();
			return teae;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateTeaex(teaexprience teae) {
		String sql = "update teasupport.teaexprience set organizationname=?,activityname=?,teaplace=?,teadescribe=? where userid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, teae.getOrganizationname());
			pstmt.setString(2, teae.getActivityname());
			pstmt.setString(3, teae.getTeaplace());
			pstmt.setString(4, teae.getTeadescribe());
			pstmt.setInt(5, teae.getUserid());
			
			// 执行插入
			if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertTeaex(teaexprience teae) {
		String sql = "insert into teasupport.teaexprience(organizationname,activityname,teaplace,teadescribe) values(?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, teae.getOrganizationname());
			pstmt.setString(2, teae.getActivityname());
			pstmt.setString(3, teae.getTeaplace());
			pstmt.setString(4, teae.getTeadescribe());
			if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertTeaexWX(int aid) {
		String sql = "insert into teasupport.teaexprience(userid) values(?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, aid);
			if (pstmt.executeUpdate() > 0) {
				conn.close();
				return true;
			} else {
				conn.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
