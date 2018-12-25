package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.news;
import com.server.entity.question;
import com.server.util.DBUtil;

public class questionDao {
	DBUtil util = new DBUtil();
	public List<question> getAllNews() {
		String sql = "select * from teasupport.question ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<question> list = new ArrayList<question>();
			while (rs.next()) {
				question qu=new question();
				qu.setQ_id(rs.getInt(1));
				qu.setQ_title(rs.getString(2));
				qu.setQ_content(rs.getString(3));
				qu.setQ_img(rs.getString(4));
				qu.setQ_time(rs.getString(5));
				list.add(qu);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public question getOneQuestion(int q_id) {
		String sql = "select * from teasupport.question where q_id=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,q_id);
			
			ResultSet rs = pstmt.executeQuery();
			question qu=new question();
			while (rs.next()) {
				qu.setQ_id(rs.getInt(1));
				qu.setQ_title(rs.getString(2));
				qu.setQ_content(rs.getString(3));
				qu.setQ_img(rs.getString(4));
				qu.setQ_time(rs.getString(5));
				
			}
			conn.close();
			return qu;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertQuestion(question qu) {
		String sql = "insert into teasupport.question(q_title,q_content,q_img,q_time) values(?,?,?,?)";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, qu.getQ_title());
			pstmt.setString(2, qu.getQ_content());
			pstmt.setString(3, qu.getQ_img());
			pstmt.setString(4, qu.getQ_time());
			
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
