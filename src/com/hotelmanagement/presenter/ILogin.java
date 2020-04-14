package com.hotelmanagement.presenter;

import java.sql.ResultSet;

public interface ILogin {
	void loginError();

	void usernameRequired();

	void passwordRequired();

	void loginSuccess(int id);
}
