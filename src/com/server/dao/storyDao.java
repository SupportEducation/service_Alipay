package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.account;
import com.server.entity.news;
import com.server.entity.story;
import com.server.entity.vorecruit;
import com.server.util.DBUtil;

public class storyDao {
	DBUtil util = new DBUtil();
	
	public List<story> getOneUserStory(int aid) {
		String sql = "select * from teasupport.story where  aid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			List<story> list = new ArrayList<story>();
			while (rs.next()) {
				account ac=new accountDao().getOneAccount(rs.getInt(2));
				story st=new story();
				st.setS_id(rs.getInt(1));
				st.setAid(rs.getInt(2));
				st.setS_time(rs.getString(3));
				st.setS_img(rs.getString(4));
				st.setS_title(rs.getString(5));
				st.setS_content(rs.getString(6));
				st.setS_place(rs.getString(7));
				st.setS_like(rs.getInt(8));
				st.setHeadimg(ac.getHeadimg());
				st.setNickname(ac.getNickname());
				list.add(st);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public story  getOneStory(int s_id) {
		String sql = "select * from teasupport.story where s_id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			story st=new story();
			while (rs.next()) {
				account ac=new accountDao().getOneAccount(rs.getInt(2));
				st.setS_id(rs.getInt(1));
				st.setAid(rs.getInt(2));
				st.setS_time(rs.getString(3));
				st.setS_img(rs.getString(4));
				st.setS_title(rs.getString(5));
				st.setS_content(rs.getString(6));
				st.setS_place(rs.getString(7));
				st.setS_like(rs.getInt(8));
				st.setHeadimg(ac.getHeadimg());
				st.setNickname(ac.getNickname());
			}
			conn.close();
			return st;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addFollow(int s_id) {
		String sql = "update teasupport.story set s_like=? where s_id=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, getFollow(s_id)+1);
			pstmt.setInt(2, s_id);
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
	
	public int  getFollow(int s_id) {
		String sql = "select s_like from teasupport.story where s_id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_id);
			
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
	//获取 用户点赞总数
	public int  getFollowSum(int aid) {
		String sql = "select SUM(s_like) as sum_like from teasupport.story where aid=?";
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
	
	public int  getFollowOneSum(int s_id) {
		String sql = "select s_like from teasupport.story where s_id=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s_id);
			
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
	
	
	public boolean insertStory(story st) {
		String sql = "insert into teasupport.story(aid,s_time,s_img,s_title,s_content,s_place) value(?,?,?,?,?,?)";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, st.getAid());
			pstmt.setString(2, st.getS_time());
			pstmt.setString(3, st.getS_img());
			pstmt.setString(4, st.getS_title());
			pstmt.setString(5, st.getS_content());
			pstmt.setString(6, st.getS_place());
			
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
	
	public List<story> getAllStory() {
		String sql = "select * from teasupport.story";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<story> list = new ArrayList<story>();
			while (rs.next()) {
				account ac=new accountDao().getOneAccount(rs.getInt(2));
				story st=new story();
				st.setS_id(rs.getInt(1));
				st.setAid(rs.getInt(2));
				st.setS_time(rs.getString(3));
				st.setS_img(rs.getString(4));
				st.setS_title(rs.getString(5));
				st.setS_content(rs.getString(6));
				st.setS_place(rs.getString(7));
				st.setS_like(rs.getInt(8));
				st.setHeadimg(ac.getHeadimg());
				st.setNickname(ac.getNickname());
				list.add(st);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteStory(int s_id) {
		String sql = "delete from teasupport.story where s_id=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, s_id);
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
	
	public boolean updateLikeNum(int s_like,int s_id) {
		String sql = "update teasupport.story set s_like=?  where s_id=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1,s_like);
			pstmt.setInt(2, s_id);
			
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
