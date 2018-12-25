package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.account;
import com.server.entity.organization;
import com.server.entity.recruit;
import com.server.util.DBUtil;

public class OrganizationDao {
	DBUtil util = new DBUtil();
	
	public organization checkOrganization(String name, String pwd) {
		String sql = "select * from teasupport.organization where or_user=? and or_pwd=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,pwd);
			ResultSet rs = pstmt.executeQuery();
			organization user=new organization();
			while (rs.next()) {
				user.setOid(rs.getInt(1));
				user.setOr_name(rs.getString(2));
				user.setFonudingtime(rs.getString(3));
				user.setOr_place(rs.getString(4));
				user.setInformation(rs.getString(5));
				user.setSeatnumber(rs.getString(6));
				user.setOr_email(rs.getString(7));
				user.setOr_blognumber(rs.getString(8));
				user.setOr_wecharnumber(rs.getString(9));
				user.setOr_officialwebsite(rs.getString(10));
				user.setOr_flat(rs.getInt(11));
				user.setOr_user(rs.getString(12));
				user.setOr_pwd(rs.getString(13));
				user.setOr_logo(rs.getString(14));
				
			}
			conn.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<organization> getAllOrganization() {
		String sql = "select * from teasupport.organization ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<organization> list = new ArrayList<organization>();
			while (rs.next()) {
				organization user=new organization();
				user.setOid(rs.getInt(1));
				user.setOr_name(rs.getString(2));
				user.setFonudingtime(rs.getString(3));
				user.setOr_place(rs.getString(4));
				user.setInformation(rs.getString(5));
				user.setSeatnumber(rs.getString(6));
				user.setOr_email(rs.getString(7));
				user.setOr_blognumber(rs.getString(8));
				user.setOr_wecharnumber(rs.getString(9));
				user.setOr_officialwebsite(rs.getString(10));
				user.setOr_flat(rs.getInt(11));
				user.setOr_user(rs.getString(12));
				user.setOr_pwd(rs.getString(13));
				user.setOr_logo(rs.getString(14));
				list.add(user);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public organization getOneOrganization(String oid) {
		String sql = "select * from teasupport.organization where oid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1,oid);
			
			ResultSet rs = pstmt.executeQuery();
			organization user=new organization();
			while (rs.next()) {
				user.setOid(rs.getInt(1));
				user.setOr_name(rs.getString(2));
				user.setFonudingtime(rs.getString(3));
				user.setOr_place(rs.getString(4));
				user.setInformation(rs.getString(5));
				user.setSeatnumber(rs.getString(6));
				user.setOr_email(rs.getString(7));
				user.setOr_blognumber(rs.getString(8));
				user.setOr_wecharnumber(rs.getString(9));
				user.setOr_officialwebsite(rs.getString(10));
				user.setOr_flat(rs.getInt(11));
				user.setOr_user(rs.getString(12));
				user.setOr_pwd(rs.getString(13));
				user.setOr_logo(rs.getString(14));
			}
			conn.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean ExamineOrganization(organization or) {
		String sql = "update teasupport.organization set or_flat=? where oid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			
			pstmt.setInt(1, or.getOr_flat());
			pstmt.setInt(2, or.getOid());
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
	
	public boolean DeleteOrganization(String oid) {
		String sql = "delete  from teasupport.organization  where oid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, Integer.parseInt(oid));
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
	public int getOneOidBYname(String name) {
		String sql = "select oid from teasupport.organization where or_user=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1,name);
			
			ResultSet rs = pstmt.executeQuery();
			int oid=0;
			while (rs.next()) {
				oid=rs.getInt(1);
				
			}
			conn.close();
			return oid;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public boolean updateOrganization(organization or) {
		String sql = "update teasupport.organization set or_name=?,fonudingtime=?,or_place=?,information=?,seatnumber=?,or_email=?,or_blognumber=?,or_wecharnumber=?,or_officialwebsite=?,or_logo=? where or_user=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1,or.getOr_name());
			pstmt.setString(2, or.getFonudingtime());
			pstmt.setString(3, or.getOr_place());
			pstmt.setString(4, or.getInformation());
			pstmt.setString(5, or.getSeatnumber());
			pstmt.setString(6, or.getOr_email()); 
			pstmt.setString(7, or.getOr_blognumber());
			pstmt.setString(8, or.getOr_wecharnumber());
			pstmt.setString(9, or.getOr_officialwebsite());
			pstmt.setString(10, or.getOr_logo());
			pstmt.setString(11,or.getOr_user());
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
	
	public int getOrState(String oid) {
		String sql = "select or_flat from teasupport.organization where oid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1,oid);
			
			ResultSet rs = pstmt.executeQuery();
			int oflat=0;
			while (rs.next()) {
				oflat=rs.getInt(1);
				
			}
			conn.close();
			return oflat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean insertOrganization(String username,String pwd) {
		String sql = "insert into teasupport.organization(or_user,or_pwd) values(?,?)";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, username);
			pstmt.setString(2,pwd);

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
	
	public String getOneOrganizationByname(String name) {
		String sql = "select or_name from teasupport.organization where or_user=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1,name);
			
			ResultSet rs = pstmt.executeQuery();
			String name1="";
			while (rs.next()) {
				name1=rs.getString(1);
	
			}
			conn.close();
			return name1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
