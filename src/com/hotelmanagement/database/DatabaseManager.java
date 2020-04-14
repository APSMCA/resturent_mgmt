package com.hotelmanagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	
	private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private static final String MYSQL_CONNECTOR = "jdbc:mysql://localhost/";
	private static final String DATABASE = "hotelmgmt";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(MYSQL_DRIVER);
			connection = DriverManager.getConnection(MYSQL_CONNECTOR + DATABASE, USERNAME, PASSWORD);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}

}
