package com.project;

import java.sql.Connection;
import java.sql.DriverManager;

// Database connection information

public class DataBaseConnect {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/school_management_system";
	static String user = "root";
	static String pw = "root";
	static Connection conn = null;
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			if (conn== null) {
				System.out.println("Error in connection");
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return conn;
	}
	}