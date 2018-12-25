package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.server.entity.organization;
import com.server.entity.recruit;
import com.server.entity.user;
import com.server.util.DBUtil;

public class recruitDao {
	DBUtil util = new DBUtil();
	
	public List<recruit> getAllRecruit() {
		String sql = "select * from teasupport.recruit ";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<recruit> list = new ArrayList<recruit>();
			while (rs.next()) {
				recruit user=new recruit();
				user.setRid(rs.getInt(1));
				user.setOid(rs.getInt(2));
				user.setRe_title(rs.getString(3));
				user.setRe_deadline(rs.getString(4));
				user.setRe_servicetime(rs.getString(5));
				user.setRe_serviceplace(rs.getString(6));
				user.setRe_jobcontent(rs.getString(7));
				user.setRe_treatment(rs.getString(8));
				user.setRe_condition(rs.getString(9));
				user.setRe_peopleenumber(rs.getString(10));
				user.setRe_flat(rs.getInt(11));
				user.setRe_type(rs.getString(12));
				user.setRe_img(rs.getString(13));
				list.add(user);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public recruit getOneRecruit(int rid) {
		String sql = "select * from teasupport.recruit where rid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,rid);
			
			ResultSet rs = pstmt.executeQuery();
			recruit user=new recruit();
			while (rs.next()) {
				user.setRid(rs.getInt(1));
				user.setOid(rs.getInt(2));
				user.setRe_title(rs.getString(3));
				user.setRe_deadline(rs.getString(4));
				user.setRe_servicetime(rs.getString(5));
				user.setRe_serviceplace(rs.getString(6));
				user.setRe_jobcontent(rs.getString(7));
				user.setRe_treatment(rs.getString(8));
				user.setRe_condition(rs.getString(9));
				user.setRe_peopleenumber(rs.getString(10));
				user.setRe_flat(rs.getInt(11));
				user.setRe_type(rs.getString(12));
				user.setRe_img(rs.getString(13));
			}
			conn.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean ExamineRecruit(int flat,int rid) {
		String sql = "update teasupport.recruit set re_flat=? where rid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			
			pstmt.setInt(1, flat);
			pstmt.setInt(2, rid);
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
	
	public boolean insertRecruit(recruit re) {
		String sql = "insert into teasupport.recruit(oid,re_title,re_deadline,re_servicetime,re_serviceplace,re_jobcontent,re_treatment,re_condition,re_peoplenumber,re_type,re_img) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, re.getOid());
			pstmt.setString(2, re.getRe_title());
			pstmt.setString(3, re.getRe_deadline());
			pstmt.setString(4, re.getRe_servicetime());
			pstmt.setString(5, re.getRe_serviceplace());
			pstmt.setString(6, re.getRe_jobcontent());
			pstmt.setString(7, re.getRe_treatment());
			pstmt.setString(8, re.getRe_condition());
			pstmt.setString(9, re.getRe_peopleenumber());
			pstmt.setString(10, re.getRe_type());
			pstmt.setString(11, re.getRe_img());
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
	
	
	public boolean updateRecruit(recruit re) {
		String sql = "update teasupport.recruit set re_title=?,re_deadline=?,re_servicetime=?,re_serviceplace=?,re_jobcontent=?,re_treatment=?,re_condition=?,re_peoplenumber=?,re_type=?,re_img=? where rid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setString(1, re.getRe_title());
			pstmt.setString(2, re.getRe_deadline());
			pstmt.setString(3, re.getRe_servicetime());
			pstmt.setString(4, re.getRe_serviceplace());
			pstmt.setString(5, re.getRe_jobcontent());
			pstmt.setString(6, re.getRe_treatment());
			pstmt.setString(7, re.getRe_condition());
			pstmt.setString(8, re.getRe_peopleenumber());
			pstmt.setString(9, re.getRe_type());
			pstmt.setString(10, re.getRe_img());
			pstmt.setInt(11, re.getRid());
			
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
	
	public boolean DeleteRecruit(int rid) {
		String sql = "delete from teasupport.recruit  where rid=?";
		// 获得连接
		Connection conn = util.getConnection();
		try {
			// 获得预定义语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 设置插入参数
			pstmt.setInt(1, rid);
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
	public String getOneReName(int rid) {
		String sql = "select re_title from teasupport.recruit where rid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,rid);
			
			ResultSet rs = pstmt.executeQuery();
			String title="";
			while (rs.next()) {
				title=rs.getString(1);
			}
			conn.close();
			return title;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<recruit> getOneOrRecruit(int oid) {
		String sql = "select * from teasupport.recruit where oid=?";
		Connection conn = util.getConnection();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1,oid);
			
			ResultSet rs = pstmt.executeQuery();
			List<recruit> list = new ArrayList<recruit>();
			
			while (rs.next()) {
				recruit user=new recruit();
				user.setRid(rs.getInt(1));
				user.setOid(rs.getInt(2));
				user.setRe_title(rs.getString(3));
				user.setRe_deadline(rs.getString(4));
				user.setRe_servicetime(rs.getString(5));
				user.setRe_serviceplace(rs.getString(6));
				user.setRe_jobcontent(rs.getString(7));
				user.setRe_treatment(rs.getString(8));
				user.setRe_condition(rs.getString(9));
				user.setRe_peopleenumber(rs.getString(10));
				user.setRe_flat(rs.getInt(11));
				user.setRe_type(rs.getString(12));
				user.setRe_img(rs.getString(13));
				list.add(user);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getFlat0Num() {
		String sql = "SELECT COUNT(rid) FROM teasupport.recruit where re_flat=0";
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
		String sql = "SELECT COUNT(rid) FROM teasupport.recruit where re_flat=1";
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
	
	public List<recruit> getAllRecruitFromCondition(String condition,String convalue) {
		String sql = "select * from teasupport.recruit where "+condition+"=? and re_flat=1";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, condition);
			pstmt.setString(1, convalue);
			
			ResultSet rs = pstmt.executeQuery();
			List<recruit> list = new ArrayList<recruit>();
			while (rs.next()) {
				recruit user=new recruit();
				user.setRid(rs.getInt(1));
				user.setOid(rs.getInt(2));
				user.setRe_title(rs.getString(3));
				user.setRe_deadline(rs.getString(4));
				user.setRe_servicetime(rs.getString(5));
				user.setRe_serviceplace(rs.getString(6));
				user.setRe_jobcontent(rs.getString(7));
				user.setRe_treatment(rs.getString(8));
				user.setRe_condition(rs.getString(9));
				user.setRe_peopleenumber(rs.getString(10));
				user.setRe_flat(rs.getInt(11));
				user.setRe_type(rs.getString(12));
				user.setRe_img(rs.getString(13));
				list.add(user);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<recruit> getAllRecruitFromPlace(String convalue) {
		String sql = "select * from teasupport.recruit where re_serviceplace like '%"+convalue+"%' and re_flat=1";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, condition);
//			pstmt.setString(1, convalue);
			
			ResultSet rs = pstmt.executeQuery();
			List<recruit> list = new ArrayList<recruit>();
			while (rs.next()) {
				recruit user=new recruit();
				user.setRid(rs.getInt(1));
				user.setOid(rs.getInt(2));
				user.setRe_title(rs.getString(3));
				user.setRe_deadline(rs.getString(4));
				user.setRe_servicetime(rs.getString(5));
				user.setRe_serviceplace(rs.getString(6));
				user.setRe_jobcontent(rs.getString(7));
				user.setRe_treatment(rs.getString(8));
				user.setRe_condition(rs.getString(9));
				user.setRe_peopleenumber(rs.getString(10));
				user.setRe_flat(rs.getInt(11));
				user.setRe_type(rs.getString(12));
				user.setRe_img(rs.getString(13));
				list.add(user);
			}
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
