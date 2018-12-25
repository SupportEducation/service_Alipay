package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.account;
import com.server.entity.collection;
import com.server.entity.follow;
import com.server.entity.news;
import com.server.util.DBUtil;

public class followDao {
	DBUtil util = new DBUtil();
	
	//用户关注别人的数量
	public int  getFollowSum(int aid) {
		String sql = "select COUNT(aid) from teasupport.follow where aid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			
			ResultSet rs = pstmt.executeQuery();
			
			int s_like=0;
			while (rs.next()) {
				s_like=rs.getInt(1);
			}
			conn.close();
			return s_like;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//用户被关注的数量
	public int  getByFollowSum(int aaid) {
		String sql = "select COUNT(aaid) from teasupport.follow where aaid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aaid);
			
			ResultSet rs = pstmt.executeQuery();
			
			int s_like=0;
			while (rs.next()) {
				s_like=rs.getInt(1);
			}
			conn.close();
			return s_like;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean insertFollow(follow fo) {
		String sql = "insert into teasupport.follow(aid,aaid) value(?,?)";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, fo.getAid());
			pstmt.setInt(2, fo.getAaid());
			
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
	
	public int checkFollow(follow fo) {
		// T-SQL语句
		String sql = "select * from teasupport.follow where aid=? and aaid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 执行查询
			pstmt.setInt(1, fo.getAid());
			pstmt.setInt(2,fo.getAaid());
			ResultSet rs = pstmt.executeQuery();
			
			int fid=0;
			while (rs.next()) {
				// 封装信息
				fid=rs.getInt(1);
			}
			conn.close();
			return fid;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<follow> getOneUserFollow(int aid) {
		String sql = "select * from teasupport.follow where aid=? ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			List<follow> list = new ArrayList<follow>();
			while (rs.next()) {
				follow fo=new follow();
				 fo.setF_id(rs.getInt(1));
				 fo.setAid(rs.getInt(2));
				 fo.setAaid(rs.getInt(3));
				 
				list.add(fo);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteFollow(int aid,int aaid) {
		String sql = "delete from teasupport.follow  where aid=? and aaid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, aid);
			pstmt.setInt(2, aaid);
			
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
	
	public List<follow> getOtherUserFollow(int aid) {
		String sql = "select * from teasupport.follow where aaid=? ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			List<follow> list = new ArrayList<follow>();
			while (rs.next()) {
				follow fo=new follow();
				 fo.setF_id(rs.getInt(1));
				 fo.setAid(rs.getInt(2));
				 fo.setAaid(rs.getInt(3));
				 
				list.add(fo);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	
}
