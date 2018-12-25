package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.server.entity.eduexp;
import com.server.entity.user;
import com.server.util.DBUtil;

public class EduExpDao {
	DBUtil util = new DBUtil();
	public eduexp getOneEduExp(int  uid) {
		String sql = "select * from teasupport.eduexp where userid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,uid);
			
			ResultSet rs = pstmt.executeQuery();
			eduexp edu=new eduexp();
			while (rs.next()) {
				edu.setUserid(rs.getInt(1));
				edu.setSchoolname(rs.getString(2));
				edu.setDegree(rs.getString(3));
				edu.setMajor(rs.getString(4));
			}
			conn.close();
			return edu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertEduexp(eduexp edu) {
		String sql = "insert into teasupport.eduexp(userid,schoolname,degree,major) values(?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, edu.getUserid());
			pstmt.setString(2, edu.getSchoolname());
			pstmt.setString(3, edu.getDegree());
			pstmt.setString(4, edu.getMajor());
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
	public boolean insertEduexpWX(int aid) {
		String sql = "insert into teasupport.eduexp(userid) values(?)";
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
	
	
	public boolean updateEduexp(eduexp edu) {
		String sql = "update teasupport.eduexp set schoolname=?,degree=?,major=? where userid=?";
		// 获得连接
		Connection conn = util.getConnection();
		
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, edu.getSchoolname());
			pstmt.setString(2, edu.getDegree());
			pstmt.setString(3, edu.getMajor());
			pstmt.setInt(4, edu.getUserid());
			
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
	
}
