package com.hotelmanagement.views;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hotelmanagement.controller.CategoryController;
import com.hotelmanagement.model.CategoryModel;
import com.hotelmanagement.presenter.ICategory;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Category extends JInternalFrame implements ICategory {

	private JLabel lblCategory;
	private JTextField txtCategory;
	private JButton btnSave;
	private JTable table;
	private JScrollPane jsp;
	private CategoryController controller;
	private DefaultTableModel dtm;

	public Category() {
		this.setSize(400, 360);
		this.setTitle("Category");
		this.setVisible(true);
		this.setClosable(true);
		this.setLayout(null);
		controller = new CategoryController(this);
		initComponent();
	}

	private void initComponent() {
		lblCategory = new JLabel("Category");
		txtCategory = new JTextField();
		btnSave = new JButton("Save");
		dtm = new DefaultTableModel(
				new String[][] {
					
				},
				new String[] {
						"Sr.", "Category Id", "Category Name"
				}
		);
		

		/*
		 * String[] columnHead = { "Sr.", "Category Id", "Category Name" };
		 * 
		 * String[][] rowData = { { "1", "1", "Category 1" }, { "2", "2", "Category 2"
		 * }, { "3", "3", "Category 3" }, { "4", "4", "Category 4" },
		 * 
		 * };
		 */

		table = new JTable(dtm);
		jsp = new JScrollPane(table);

		lblCategory.setBounds(20, 20, 90, 30);
		txtCategory.setBounds(20, 50, 200, 30);
		btnSave.setBounds(40, 100, 90, 30);
		jsp.setBounds(0, 140, 400, 120);

		this.add(lblCategory);
		this.add(txtCategory);
		this.add(btnSave);
		this.add(jsp);

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String category = txtCategory.getText().trim();
				controller.saveCategory(category);
			}

		});
		
		fetchData();
	}

	private void fetchData() {
		int i = 1;
		clearTableData();
		ResultSet rs = controller.getCategories();
		/*
		 * for(int i = 0; i < al.size(); i++) { CategoryModel cm = al.get(i);
		 * System.out.print("Category: "+cm.getCategoryId()+" "+cm.getCategoryName()); }
		 */
		
		try {
			while(rs.next()) {
				String[] row = {
						String.valueOf(i),
						""+rs.getInt("_id"),
						rs.getString("category_name")
				};
				dtm.addRow(row);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void clearTableData() {
		int rowCount = dtm.getRowCount();
		while(rowCount > 0) {
			dtm.removeRow(rowCount-1);
			rowCount--;
		}
	}
	
	@Override
	public void categoryRequried() {
		System.out.print("Category Required");
	}

	@Override
	public void categorySaved() {
		System.out.print("Category Saved");
		fetchData();
	}

	@Override
	public void getCategory(ResultSet rs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void categorySaveError() {

	}

}
