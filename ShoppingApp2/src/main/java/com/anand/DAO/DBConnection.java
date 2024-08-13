package com.anand.DAO;

import java.sql.*;

public class DBConnection {

	public static Connection con = null;

	private DBConnection() {

	}

	static {
		if (con == null) {
			try {
				Class.forName(DBInfo.DRIVER);
				con = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getCon() {
		return con;
	}
}
