package com.hotelmanagement.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hotelmanagement.database.DatabaseManager;

public class ResturentRegistrationRepo {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ResturentRegistrationRepo() {
		// TODO Auto-generated constructor stub
	}

	public String getResturentName(int id) {
		try {
			con = DatabaseManager.getConnection();
			stmt = con.createStatement();
			String query = "SELECT resturent_name FROM resturent_registration WHERE _id = " + id + " ";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
