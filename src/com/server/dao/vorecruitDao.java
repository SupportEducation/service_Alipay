package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.organization;
import com.server.entity.user;
import com.server.entity.vorecruit;
import com.server.util.DBUtil;

public class vorecruitDao {
	DBUtil util = new DBUtil();
	public List<vorecruit> getAllVoRecruit() {
		String sql = "select * from teasupport.vorecruit ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<vorecruit> list = new ArrayList<vorecruit>();
			while (rs.next()) {
				vorecruit vo=new vorecruit();
				vo.setVid(rs.getInt(1));
				vo.setRid(rs.getInt(2));
				vo.setAid(rs.getInt(3));
				vo.setVflat(rs.getInt(4));
				list.add(vo);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean ExamineVorecruit(int vid,int flat) {
		String sql = "update teasupport.vorecruit set vflat=? where vid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			
			pstmt.setInt(1, flat);
			pstmt.setInt(2, vid);
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
	
	public int getFlat0Num() {
		String sql = "SELECT COUNT(vid) FROM teasupport.vorecruit where vflat=0";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			ResultSet rs = pstmt.executeQuery();
			int sum=0;
			while (rs.next()) {
				sum=rs.getInt(1);
			}
			conn.close();
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int getFlat1Num() {
		String sql = "SELECT COUNT(vid) FROM teasupport.vorecruit where vflat=1";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			ResultSet rs = pstmt.executeQuery();
			int sum=0;
			while (rs.next()) {
				sum=rs.getInt(1);
			}
			conn.close();
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<vorecruit>  getOneVoRecruitByAid(int aid) {
		String sql = "select * from teasupport.vorecruit where aid=? and vflat=1";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			
			List<vorecruit> list = new ArrayList<vorecruit>();
			while (rs.next()) {
				vorecruit vo=new vorecruit();
				vo.setVid(rs.getInt(1));
				vo.setRid(rs.getInt(2));
				vo.setAid(rs.getInt(3));
				vo.setVflat(rs.getInt(4));
				list.add(vo);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<vorecruit>  getOneVoRecruitByAidAllStates(int aid) {
		String sql = "select * from teasupport.vorecruit where aid=? ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			
			List<vorecruit> list = new ArrayList<vorecruit>();
			while (rs.next()) {
				vorecruit vo=new vorecruit();
				vo.setVid(rs.getInt(1));
				vo.setRid(rs.getInt(2));
				vo.setAid(rs.getInt(3));
				vo.setVflat(rs.getInt(4));
				list.add(vo);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getFlat1NumByaid(int aid) {
		String sql = "SELECT COUNT(vid) FROM teasupport.vorecruit where vflat=1 and aid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			int sum=0;
			while (rs.next()) {
				sum=rs.getInt(1);
			}
			conn.close();
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean insertVorecruit(int rid,int aid) {
		String sql = "insert into teasupport.vorecruit(rid,aid) value(?,?)";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			
			pstmt.setInt(1, rid);
			pstmt.setInt(2, aid);
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
	
	public vorecruit getOneVorecruit(String rid,String aid) {
		String sql = "select * from teasupport.vorecruit where rid=? and aid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1,rid);
			pstmt.setString(2,aid);
			
			ResultSet rs = pstmt.executeQuery();
			vorecruit vo=new vorecruit();
			while (rs.next()) {
				vo.setVid(rs.getInt(1));
				vo.setRid(rs.getInt(2));
				vo.setAid(rs.getInt(3));
				vo.setVflat(rs.getInt(4));
			}
			conn.close();
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
