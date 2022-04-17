package cn.edu.qvtu.Message01.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import cn.edu.qvtu.Message02.dao.DBConnection;

public class Test {
	private static Connection conn;
	private static PreparedStatement pstm;
	private static ResultSet rs;
	private static HashMap<String, String> map;
	static {
		map = new HashMap<String, String>();
		map.put("bigint", "long");
		map.put("varchar", "String");
		map.put("tinyint", "byte");

	}

	private static void create(String tbName) {
		String strSQL = "show full columns from " + tbName;
		try {
			conn = DBConnection.getDBConnection();
			pstm = conn.prepareStatement(strSQL);
			rs = pstm.executeQuery();
			while (rs.next()) {
				// System.out
				// .println(rs.getString("Field") + "\t" + rs.getString("Type") + "\t" +
				// rs.getString("Comment"));
				print(rs.getString("Field"), rs.getString("Type"), rs.getString("Comment"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstm, rs);
		}
	}

	private static void print(String field, String type, String comment) {
		int index = type.indexOf('(');
		if (index != -1) {
			type = type.substring(0, index);
		}
		String str = "private " + map.get(type) + " " + field + ";";
		if (!comment.isEmpty()) {
			str = str + "//" + comment;
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		create("company_");

	}
}
