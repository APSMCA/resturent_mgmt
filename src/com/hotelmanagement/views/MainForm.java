package com.hotelmanagement.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainForm extends JFrame {

	private JMenuBar menuBar;
	private JMenu menuMaster, menuSale, menuReports, menuHelp;
	private JMenuItem menuProducts, menuCategory, menuSales, menuPurchase, menuAbout;
	private JDesktopPane desktopPane;

	public MainForm() {
		this.setTitle("Main Form");
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		initComponent();
	}

	private void initComponent() {
		menuBar = new JMenuBar();
		menuMaster = new JMenu("Master");
		menuSales = new JMenu("Sales");
		menuReports = new JMenu("Report");
		menuHelp = new JMenu("Help");

		menuProducts = new JMenuItem("Products");
		menuCategory = new JMenuItem("Category");

		desktopPane = new JDesktopPane();
		this.add(desktopPane);

		addMenus();
		setupListeners();
	}

	private void addMenus() {
		this.setJMenuBar(menuBar);
		// set Menu to MenuBar
		menuBar.add(menuMaster);
		menuBar.add(menuSales);
		menuBar.add(menuReports);
		menuBar.add(menuHelp);

		// add menuitem to menu
		menuMaster.add(menuProducts);
		menuMaster.add(menuCategory);
	}

	private void setupListeners() {
		menuCategory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Category category = new Category();
				desktopPane.add(category);
			}

		});
	}

	public static void main(String[] args) {
		MainForm mf = new MainForm();
		mf.setVisible(true);
	}

}
