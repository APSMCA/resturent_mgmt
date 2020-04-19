package com.hotelmanagement.presenter;

import java.sql.ResultSet;

public interface ICategory {
	void categoryRequried();
	void categorySaved();
	void categorySaveError();
	void getCategory(ResultSet rs);
}
