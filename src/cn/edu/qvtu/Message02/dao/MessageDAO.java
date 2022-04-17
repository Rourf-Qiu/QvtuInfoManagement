package cn.edu.qvtu.Message02.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.qvtu.Message01.entity.Message;

public class MessageDAO {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	public int add(Message message) {
		String strSQL = "INSERT INTO message VALUES(?,?,?,?)";
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1, message.getMessage_ID());
			pstm.setString(2, message.getMessage_Title());
			pstm.setString(3, message.getMessage_Txt());
			pstm.setString(4, message.getMessage_Name());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		return -1;
	}
	public Message selMax() {
		String strSQL = "SELECT * FROM message WHERE message_ID=(SELECT MAX(message_ID) FROM message)";
		
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			rs = pstm.executeQuery();
			if(rs.next()) {
				Message message = new Message();
				long time = rs.getLong("message_ID");
			    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日-hh时mm分ss秒");
			    Date date = new Date(time);
			    String str = format.format(date);
				message.setMessage_ID(rs.getLong("message_ID"));
				message.setMessage_Name(rs.getString("message_Name"));
				message.setMessage_Title(rs.getString("message_Title"));
				message.setMessage_Txt(rs.getString("message_Txt"));
				message.setBeizhu(str);
				return message;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		return null;
	}
	public List<Message> selAllmsg(){
		String strSQL = "SELECT * FROM message";
		List<Message> list = new  ArrayList<Message>();
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Message msg = new Message();
				msg.setMessage_ID(rs.getLong("message_ID"));
				msg.setMessage_Name(rs.getString("message_Name"));
				msg.setMessage_Title(rs.getString("message_Title"));
				msg.setMessage_Txt(rs.getString("message_Txt"));
				list.add(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		return list;
	}
	public int delete() {
		String strSQL = "DELETE FROM message WHERE message_ID < ?";
		String strSQL1 = "select max(message_ID) from message";
		long time = System.currentTimeMillis()-3600000;
		long max = 1;
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL1);
			rs =  pstm.executeQuery();
			if(rs.next()) {
				max = rs.getLong("max(message_ID)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			pstm.setLong(1, max);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, pstm, rs);
		}
		return -1;
	}
	
}
