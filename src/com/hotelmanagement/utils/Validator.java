package com.hotelmanagement.utils;

public class Validator {

	public static boolean isValidEmail(String email) {
		int pos = email.indexOf("@");
		if(pos != -1) {
			int dot = email.lastIndexOf(".");
			if(dot != -1 && dot > pos) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isValidPhoneNo(String phone) {
		if(phone != null) {
			if(phone.length() == 10) {
				return true;
			}
		}
		return false;
	}

}
