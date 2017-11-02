package com.neuedu.tipd.my12306.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
	
	private static String username = "MY12306";
	
	private static String password = "123123";

	private static String url = "jdbc:oracle:thin:@localhost:1521/orcl";
	
	private static String Driver = "oracle.jdbc.driver.OracleDriver";
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void closeAll(Connection con,Statement stmt,ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
