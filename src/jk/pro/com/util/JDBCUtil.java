package jk.pro.com.util;

import java.sql.*;

public class JDBCUtil {

	public static Connection getMysqlConnection() {
			//added comment
		Connection con = null;
		try {
			// 1.load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost/SMDB1", "root", "qwer1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void cleanUp(Connection con, Statement st) {
		try {
			// 7.release the resources
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cleanUp(Connection con, Statement st, ResultSet rs) {
		try {
			// 7.release the resources
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
