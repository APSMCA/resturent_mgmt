package com.hotelmanagement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hotelmanagement.repository.ResturentRegistrationRepo;

public class MainController {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private ResturentRegistrationRepo regRepo;

	public MainController() {
		regRepo = new ResturentRegistrationRepo();
	}

	public String getResturentName(int id) {
		return regRepo.getResturentName(id);
	}

}
