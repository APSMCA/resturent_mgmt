package com.hotelmanagement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hotelmanagement.database.DatabaseManager;
import com.hotelmanagement.presenter.ILogin;

public class LoginController {

	private ILogin loginListener;
	private boolean isValid = true;

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public LoginController(ILogin loginListener) {
		this.loginListener = loginListener;
		isValid = true;
	}

	public void performLogin(String username, String password) {
		if (username == null && username.isEmpty()) {
			loginListener.usernameRequired();
			isValid = false;
		}

		if (password == null && password.isEmpty()) {
			loginListener.passwordRequired();
			isValid = false;
		}

		if (isValid) {
			makeLoginRequest(username, password);
		}

	}

	private void makeLoginRequest(String username, String password) {
		try {
			con = DatabaseManager.getConnection();
			stmt = con.createStatement();
			String query = "SELECT * FROM resturent_registration WHERE username = '" + username
					+ "' AND password = SHA1('" + password + "')";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				loginListener.loginSuccess(rs.getInt("_id"));
			} else {
				loginListener.loginError();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
