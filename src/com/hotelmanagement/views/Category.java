package com.hotelmanagement.views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Category extends JInternalFrame {
	
	private JLabel lblCategory;
	private JTextField txtCategory;

	public Category() {
		this.setSize(300,400);
		this.setTitle("Category");
		this.setVisible(true);
		this.setLayout(null);
		initComponent();
	}
	
	private void initComponent() {
		lblCategory = new JLabel("Category");
		txtCategory = new JTextField();
		
		lblCategory.setBounds(20,20,90,30);
		txtCategory.setBounds(20, 50, 120, 30);
		
		
		this.add(lblCategory);
		this.add(txtCategory);
	}

}
