package com.hotelmanagement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.hotelmanagement.database.DatabaseManager;
import com.hotelmanagement.model.CategoryModel;
import com.hotelmanagement.presenter.ICategory;

public class CategoryController {

	private ICategory icategory;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private ArrayList<CategoryModel> al;

	public CategoryController(ICategory icategory) {
		this.icategory = icategory;
		al = new ArrayList<CategoryModel>();
	}

	public void saveCategory(String category) {
		if(category!=null && category.length() > 0) {
			try {
				con = DatabaseManager.getConnection();
				stmt = con.createStatement();
				String query = "INSERT INTO category (category_name) VALUES ('"+category+"')";
				int result = stmt.executeUpdate(query);
				if(result == -1) {
					icategory.categorySaveError();
				}else {
					icategory.categorySaved();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}else {
			icategory.categoryRequried();
		}
	}
	
	public ResultSet getCategories() {
		try {
			con = DatabaseManager.getConnection();
			stmt = con.createStatement();
			String query = "SELECT * FROM category";
			rs = stmt.executeQuery(query);
			return rs;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
