package cn.edu.qvtu.Message02.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//类不能被其它类继承
public final class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/information";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER_NAME = "root";
	private static final String USER_PSW = "root";

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// final:最终形态，不能被子类重写
	public static final Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER_NAME, USER_PSW);
	}

	public static final void close(Connection conn, PreparedStatement pstm, ResultSet rs) {
		close(rs);
		close(pstm);
		close(conn);
	}

	private static final void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static final void close(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static final void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
