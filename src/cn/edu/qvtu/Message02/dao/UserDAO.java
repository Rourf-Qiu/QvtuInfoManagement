package cn.edu.qvtu.Message02.dao;
//操作数据库

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.qvtu.Message01.entity.User;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;

	public User login(User user) {
		String strSQL = "SELECT * FROM user WHERE userID=? AND userPSW=?";
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1, user.getUserID());
			pstm.setString(2, user.getUserPSW());
			rs = pstm.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUserID(rs.getLong("userID"));
				user.setUserClass(rs.getString("userClass"));
				user.setUserIdentity(rs.getString("userIdentity"));
				user.setUserName(rs.getString("userName"));
				user.setUserPSW(rs.getString("userPSW"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserType(rs.getString("userType"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		return null;
	}

	public int add(User user) {
		String strSQL = "INSERT INTO User VALUES(?,?,?,?,?,?,?,?)";
		System.out.println(user.toString());
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1, user.getUserID());
			pstm.setString(2, user.getUserName());
			pstm.setString(3, user.getUserSex());
			pstm.setString(4, user.getUserClass());
			pstm.setString(5, user.getUserType());
			pstm.setString(6, user.getUserIdentity());
			pstm.setLong(7, user.getID());
			pstm.setString(8, user.getUserPSW());
			return pstm.executeUpdate();// 返回执行成功的行数

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstm, rs);
		}
		return 0;
	}

	public List<User> selAll() {
		String strSQL = "SELECT * FROM User";
		List<User> list = new ArrayList<User>();
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			rs = pstm.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUserClass(rs.getString("userClass"));
				user.setUserIdentity(rs.getString("userIdentity"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserName(rs.getString("userName"));
				user.setUserType(rs.getString("userType"));
				user.setUserID(rs.getLong("userID"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int update(User user) {
		String strSQL = "UPDATE user SET userID=?,userClass=?,userIdentity=?,userType=?,userName=?,userSex=? WHERE userID=?";
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1,user.getUserID());
			pstm.setString(2, user.getUserClass());
			pstm.setString(3, user.getUserIdentity());
			pstm.setString(4, user.getUserType());
			pstm.setString(5, user.getUserName());
			pstm.setString(6, user.getUserSex());
			pstm.setLong(7, user.getUserID());
			System.out.println(pstm.toString());
			return pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstm, rs);
		}

		return -1;
	}

	public int delete(long userID) {
		String strSQL = "DELETE FROM User WHERE userID=?";
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1, userID);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstm, rs);
		}
		return -1;

	}

	public int resetPSW(String newPSW, String jiuMiMa, long userId) {
		String strSQL = "UPDATE user SET userPSW=? WHERE userPSW=? AND userID=?";
		
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setString(1, newPSW);
			pstm.setString(2, jiuMiMa);
			pstm.setLong(3, userId);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstm, rs);
		}

		return -1;
	}
	
	public User selUserName(User user) {
		String strSQL = "SELECT * FROM User WHERE userID=?";
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1, user.getUserID());
			rs = pstm.executeQuery();
			if(rs.next()) {
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		return null;
	}
	public User selUserInfo(long userID) {
		String strSQL = "SELECT * FROM User WHERE userID=?";
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1, userID);
			rs = pstm.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserID(userID);
				user.setUserClass(rs.getString("userClass"));
				user.setUserName(rs.getString("userName"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		return null;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
