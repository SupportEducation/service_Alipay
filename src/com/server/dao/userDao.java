package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.user;
import com.server.util.DBUtil;

public class userDao {
	DBUtil util = new DBUtil();
	
	public List<user> getAlluser() {
		String sql = "select * from teasupport.user ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<user> list = new ArrayList<user>();
			while (rs.next()) {
				user us=new user();
				us.setUserid(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setBorndate(rs.getString(3));
				us.setArea(rs.getString(4));
				us.setNation(rs.getString(5));
				us.setSex(rs.getString(6));
				us.setPhonenumber(rs.getString(7));
				us.setEmail(rs.getString(8));
				us.setIdnumber(rs.getString(9));
				us.setLifephoto(rs.getString(10));
				us.setWorkaddress(rs.getString(11));
				us.setHomeaddress(rs.getString(12));
				us.setEmergancycontact(rs.getString(13));
				us.setEmergancyrelationship(rs.getString(14));
				
				list.add(us);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean DeleteUserByid(int id) {
		String sql = "delete from teasupport.user  where userid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, id);
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
	
	public user getOneUser(int  uid) {
		String sql = "select * from teasupport.user where userid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,uid);
			
			ResultSet rs = pstmt.executeQuery();
			user us=new user();
			while (rs.next()) {
				us.setUserid(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setBorndate(rs.getString(3));
				us.setArea(rs.getString(4));
				us.setNation(rs.getString(5));
				us.setSex(rs.getString(6));
				us.setPhonenumber(rs.getString(7));
				us.setEmail(rs.getString(8));
				us.setIdnumber(rs.getString(9));
				us.setLifephoto(rs.getString(10));
				us.setWorkaddress(rs.getString(11));
				us.setHomeaddress(rs.getString(12));
				us.setEmergancycontact(rs.getString(13));
				us.setEmergancyrelationship(rs.getString(14));
				
			}
			conn.close();
			return us;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getUserid(String  username) {
		String sql = "select userid from teasupport.user where name=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1,username);
			
			ResultSet rs = pstmt.executeQuery();
			int userid=0;
			while (rs.next()) {
				userid=rs.getInt(1);
				
			}
			conn.close();
			return userid;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean insertUser1(user us) {
		String sql = "insert into teasupport.user(name,borndate,area,nation,sex,phonenumber,email,idnumber,lifephoto,userid) values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, us.getName());
			pstmt.setString(2, us.getBorndate());
			pstmt.setString(3, us.getArea());
			pstmt.setString(4, us.getNation());
			pstmt.setString(5, us.getSex());
			pstmt.setString(6, us.getPhonenumber());
			pstmt.setString(7, us.getEmail());
			pstmt.setString(8, us.getIdnumber());
			pstmt.setString(9, us.getLifephoto());
			pstmt.setInt(10, us.getUserid());
	
			
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
	
	public boolean insertUser2(user us) {
		String sql = "insert into teasupport.user(workaddress,homeaddress,emergencycontact,emergancyrelationship,userid) values(?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, us.getWorkaddress());
			pstmt.setString(2, us.getHomeaddress());
			pstmt.setString(3, us.getEmergancycontact());
			pstmt.setString(4, us.getEmergancyrelationship());
			pstmt.setInt(5, us.getUserid());
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
	
	public boolean insertUser(int aid) {
		String sql = "insert into teasupport.user(userid) values(?)";
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
	
	public boolean updateUser1(user us) {
		String sql = "update teasupport.user set name=?,borndate=?,area=?,nation=?,sex=?,phonenumber=?,email=?,idnumber=?,lifephoto=? where userid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, us.getName());
			pstmt.setString(2, us.getBorndate());
			pstmt.setString(3, us.getArea());
			pstmt.setString(4, us.getNation());
			pstmt.setString(5, us.getSex());
			pstmt.setString(6, us.getPhonenumber());
			pstmt.setString(7, us.getEmail());
			pstmt.setString(8, us.getIdnumber());
			pstmt.setString(9, us.getLifephoto());
			pstmt.setInt(10, us.getUserid());
			
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
	
	public boolean updateUser2(user us) {
		String sql = "update teasupport.user set workaddress=?,homeaddress=?,emergencycontact=?,emergancyrelationship=? where userid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, us.getWorkaddress());
			pstmt.setString(2, us.getHomeaddress());
			pstmt.setString(3, us.getEmergancycontact());
			pstmt.setString(4, us.getEmergancyrelationship());
			pstmt.setInt(5, us.getUserid());
			
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
