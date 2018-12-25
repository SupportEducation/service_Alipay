package com.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.server.entity.account;
import com.server.util.DBUtil;

public class accountDao {
	DBUtil util = new DBUtil();

	public account checkaccount(account ac) {
		String sql = "select * from teasupport.account where username=? and password=? and aflat=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ac.getUsername());
			pstmt.setString(2, ac.getPassword());
			pstmt.setInt(3, ac.getAflat());
			ResultSet rs = pstmt.executeQuery();
			account acc = new account();
			while (rs.next()) {
				acc.setAid(rs.getInt(1));
				acc.setPassword(rs.getString(2));
				acc.setAflat(rs.getInt(3));
				acc.setUsername(rs.getString(4));
				acc.setHeadimg(rs.getString(5));
			}
			conn.close();
			return acc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean DeleteAccount(String username) {
		String sql = "delete from teasupport.account  where username=?";
		// �������
		Connection conn = util.getConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò������
			pstmt.setString(1, username);
			// ִ�в���
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

	public account getOneAccount(int aid) {
		String sql = "select * from teasupport.account where aid=?";
		Connection conn = util.getConnection();

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);

			ResultSet rs = pstmt.executeQuery();
			account user = new account();
			while (rs.next()) {
				user.setAid(rs.getInt(1));
				user.setPassword(rs.getString(2));
				user.setAflat(rs.getInt(3));
				user.setUsername(rs.getString(4));
				user.setHeadimg(rs.getString(5));
				user.setNickname(rs.getString(6));
			}
			conn.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean DeleteAccountByid(int id) {
		String sql = "delete from teasupport.account  where aid=?";
		// �������
		Connection conn = util.getConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò������
			pstmt.setInt(1, id);
			// ִ�в���
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

	// ����΢���ʺ� ־Ը��
	public boolean insertAccountWX(String openid, String avatarUrl,
			String nickname) {
		String sql = "insert into teasupport.account(password,aflat,username,headimg,nickname) values(?,?,?,?,?)";
		// �������
		Connection conn = util.getConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò������
			pstmt.setString(1, "123");
			pstmt.setInt(2, 2);
			pstmt.setString(3, openid);
			pstmt.setString(4, avatarUrl);
			pstmt.setString(5, nickname);

			// ִ�в���
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

	public account checkUserWX(String name) {
		// T-SQL���
		String sql = "select * from teasupport.account where username=?";
		// �������
		Connection conn = util.getConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ִ�в�ѯ
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			account ac = new account();
			while (rs.next()) {
				// ��װ��Ϣ
				ac.setAid(rs.getInt(1));
				ac.setPassword(rs.getString(2));
				ac.setAflat(rs.getInt(3));
				ac.setUsername(rs.getString(4));
				ac.setHeadimg(rs.getString(5));
				ac.setNickname(rs.getString(6));
			}
			conn.close();
			return ac;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public account getOneAccountBYusername(String username) {
		String sql = "select * from teasupport.account where username=?";
		Connection conn = util.getConnection();

		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();
			account user = new account();
			while (rs.next()) {
				user.setAid(rs.getInt(1));
				user.setPassword(rs.getString(2));
				user.setAflat(rs.getInt(3));
				user.setUsername(rs.getString(4));
			}
			conn.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ������֯�ʺ�
	public boolean insertAccountOR(account ac) {
		String sql = "insert into teasupport.account(password,aflat,username) values(?,?,?)";
		// �������
		Connection conn = util.getConnection();
		try {
			// ���Ԥ�������
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ���ò������
			pstmt.setString(1, ac.getPassword());
			pstmt.setInt(2, 1);
			pstmt.setString(3, ac.getUsername());

			// ִ�в���
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

	public account checkUsername(account ac) {
		String sql = "select * from teasupport.account where username=?";
		Connection conn = util.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ac.getUsername());
			ResultSet rs = pstmt.executeQuery();
			account acc = new account();
			while (rs.next()) {
				acc.setAid(rs.getInt(1));
				acc.setPassword(rs.getString(2));
				acc.setAflat(rs.getInt(3));
				acc.setUsername(rs.getString(4));
			}
			conn.close();
			return acc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
