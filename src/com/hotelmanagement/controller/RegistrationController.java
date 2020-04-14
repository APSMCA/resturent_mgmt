package com.hotelmanagement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hotelmanagement.database.DatabaseManager;
import com.hotelmanagement.model.RegistrationModel;
import com.hotelmanagement.utils.Validator;

public class RegistrationController {

	private IRegistration reg;
	private boolean isValid = true;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public RegistrationController(IRegistration reg) {
		this.reg = reg;
		isValid = true;
	}

	public void validated(RegistrationModel model) {
		if (!Validator.isValidEmail(model.getOwnerEmail())) {
			reg.emailError();
			isValid = false;
		}
		if (!Validator.isValidPhoneNo(model.getPhoneNo())) {
			reg.phoneError();
			isValid = false;
		}
		if (model.getOwnerName() != null && model.getOwnerName().isEmpty()) {
			reg.ownerNameRequired();
			isValid = false;
		}
		if (model.getResturentName() != null && model.getResturentName().isEmpty()) {
			reg.resturentNameRequired();
			isValid = false;
		}
		if (model.getUsername() != null && model.getUsername().isEmpty()) {
			reg.usernameRequired();
			isValid = false;
		}
		if (model.getUsername().length() < 7) {
			reg.usernameError();
			isValid = false;
		}
		if (model.getPassword() != null && model.getPassword().isEmpty()) {
			reg.passwordRequired();
			isValid = false;
		}
		if (model.getPassword().length() < 9) {
			reg.passwordError();
			isValid = false;
		}

		if (isValid) {
			// perform database operation
			registerUser(model);
		}

	}

	private void registerUser(RegistrationModel model) {
		try {
			con = DatabaseManager.getConnection();
			stmt = con.createStatement();
			String query = "INSERT INTO resturent_registration "
					+ "(resturent_name,owner_name,owner_email, phone_no ,username ,password) " + "VALUES " + "('"
					+ model.getResturentName() + "','" + model.getOwnerName() + "','" + model.getOwnerEmail() + "','"
					+ model.getPhoneNo() + "','" + model.getUsername() + "',SHA1('" + model.getPassword() + "'))";
			System.out.println("Query: "+query);
			
			int ans = stmt.executeUpdate(query);
			if(ans == 1) {
				reg.registrationSuccess();
			}else {
				reg.registrationError();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
