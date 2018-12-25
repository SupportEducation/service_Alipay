package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.collection;
import com.server.entity.follow;
import com.server.util.DBUtil;

public class collectionDao {
	DBUtil util = new DBUtil();
	
	public List<collection> getOneUserCollection(int aid) {
		String sql = "select * from teasupport.collection where  aid=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
			ResultSet rs = pstmt.executeQuery();
			List<collection> list = new ArrayList<collection>();
			while (rs.next()) {
				collection co=new collection();
				
				co.setAid(rs.getInt(1));
				co.setS_id(rs.getInt(2));
				co.setC_id(rs.getInt(3));
				
				list.add(co);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insertCollection(collection co) {
		String sql = "insert into teasupport.collection(aid,s_id) value(?,?)";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, co.getAid());
			pstmt.setInt(2, co.getS_id());
			
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
	
	public int checkCollection(collection co) {
		// T-SQL语句
		String sql = "select * from teasupport.collection where aid=? and s_id=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 执行查询
			pstmt.setInt(1,co.getAid());
			pstmt.setInt(2,co.getS_id());
			ResultSet rs = pstmt.executeQuery();
			
			int fid=0;
			while (rs.next()) {
				// 封装信息
				fid=rs.getInt(3);
			}
			conn.close();
			return fid;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
