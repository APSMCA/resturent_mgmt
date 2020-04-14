package com.hotelmanagement.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainForm extends JFrame{
	
	private MenuBar menuBar;
	private Menu menuFile,menuEdit;
	private MenuItem menuFileNew,menuFileExit;

	public MainForm() {
		this.setTitle("Main Form");
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		initComponent();
	}
	
	private void initComponent() {
		menuBar = new MenuBar();
		menuFile = new Menu("File");
		menuEdit = new Menu("Edit");
		menuFileNew = new MenuItem("New");
		menuFileExit = new MenuItem("Exit");
		
		this.setMenuBar(menuBar);
		//set Menu to MenuBar
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		
		//add menuitem to menu
		menuFile.add(menuFileNew);
		menuFile.add(menuFileExit);
	}
	
	public static void main(String[] args) {
		MainForm mf = new MainForm();
		mf.setVisible(true);
	}

}
