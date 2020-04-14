package com.hotelmanagement.presenter;

public interface IRegistration {
	void emailError();
	void phoneError();
	void resturentNameRequired();
	void ownerNameRequired();
	void passwordRequired();
	void usernameRequired();
	void passwordError();
	void usernameError();
	void usernameAlreadyExist();
	void registrationSuccess();
	void registrationError();
}
