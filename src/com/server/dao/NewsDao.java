package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.account;
import com.server.entity.news;
import com.server.util.DBUtil;

public class NewsDao {
	DBUtil util = new DBUtil();
	
	public List<news> getAllNews() {
		String sql = "select * from teasupport.news ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<news> list = new ArrayList<news>();
			while (rs.next()) {
				news ne=new news();
				ne.setNid(rs.getInt(1));
				ne.setNews_title(rs.getString(2));
				ne.setNews_time(rs.getString(3));
				ne.setNews_clickrate(rs.getString(4));
				ne.setNews_content(rs.getString(5));
				ne.setNews_img(rs.getString(6));
				list.add(ne);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean DeleteNews(int nid) {
		String sql = "delete  from teasupport.news  where nid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, nid);
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
	
	public boolean updateNews(news ne) {
		String sql = "update teasupport.news set news_title=?,news_time=?,news_content=?,news_img=? where nid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1,ne.getNews_title());
			pstmt.setString(2, ne.getNews_time());
			pstmt.setString(3, ne.getNews_content());
			pstmt.setString(4, ne.getNews_img());
			pstmt.setInt(5, ne.getNid());
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
	public boolean insertNews(news ne) {
		String sql = "insert into teasupport.news(news_title,news_time,news_content,news_img) values(?,?,?,?)";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, ne.getNews_title());
			pstmt.setString(2,ne.getNews_time());
			pstmt.setString(3, ne.getNews_content());
			pstmt.setString(4, ne.getNews_img());
			
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
	
	public news getOneNews(int nid) {
		String sql = "select * from teasupport.news where nid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,nid);
			
			ResultSet rs = pstmt.executeQuery();
			news ne=new news();
			while (rs.next()) {
				ne.setNid(rs.getInt(1));
				ne.setNews_title(rs.getString(2));
				ne.setNews_time(rs.getString(3));
				ne.setNews_clickrate(rs.getString(4));
				ne.setNews_content(rs.getString(5));
				ne.setNews_img(rs.getString(6));
			}
			conn.close();
			return ne;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
