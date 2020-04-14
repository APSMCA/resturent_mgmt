package com.hotelmanagement.views;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.hotelmanagement.controller.LoginController;
import com.hotelmanagement.presenter.ILogin;

public class LoginForm extends JFrame implements ILogin {
	private static final long serialVersionUID = 1L;

	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel lblRegister;

	private LoginController controller;

	public LoginForm() {
		this.setBounds(400, 200, 350, 240);
		this.setTitle("Login Screen");
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		controller = new LoginController(this);
		initComponent();
	}

	private void initComponent() {
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("Login");
		lblRegister = new JLabel("Register yet register? Click Here");
		lblRegister.setForeground(Color.BLUE);

		setComponentPlacement();
		addingComponent();
		setupListeners();

	}

	private void setComponentPlacement() {
		lblUsername.setBounds(20, 20, 90, 30);
		txtUsername.setBounds(120, 20, 200, 30);
		lblPassword.setBounds(20, 60, 90, 30);
		txtPassword.setBounds(120, 60, 200, 30);
		btnLogin.setBounds(120, 100, 90, 30);
		lblRegister.setBounds(60, 140, 260, 30);
	}

	private void addingComponent() {
		this.add(lblUsername);
		this.add(txtUsername);
		this.add(lblPassword);
		this.add(txtPassword);
		this.add(btnLogin);
		this.add(lblRegister);

	}

	private void setupListeners() {

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onLoginButtonClick();
			}

		});

	}

	private void onLoginButtonClick() {
		boolean isValid = true;
		String username = txtUsername.getText().trim();
		String password = new String(txtPassword.getPassword()).trim();
		controller.performLogin(username, password);

		if (username.isEmpty()) {
			System.out.println("Username Required");
			isValid = false;
		}
		if (password.isEmpty()) {
			System.out.println("Password Required");
			isValid = false;
		}
		if (isValid) {
			if (username.equals("admin") && password.equals("password")) {
				System.out.println("login Success");
			} else {
				System.out.println("Invalid input");
			}
		}
	}

	private void openRegisterPage() {
		RegisterForm rf = new RegisterForm();
		rf.setVisible(true);
		this.dispose();
	}

	public static void main(String[] args) {
		LoginForm lf = new LoginForm();
		lf.setVisible(true);
	}

	@Override
	public void loginError() {
		JOptionPane.showMessageDialog(this, "Invalid username or password", "Login error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void usernameRequired() {
		JOptionPane.showMessageDialog(this, "Please input username", "Username required", JOptionPane.ERROR_MESSAGE);
		txtPassword.setText("");
	}

	@Override
	public void passwordRequired() {
		JOptionPane.showMessageDialog(this, "Please input password", "Password required", JOptionPane.ERROR_MESSAGE);
		txtPassword.setText("");
	}

	@Override
	public void loginSuccess(int id) {
		MainForm mf = new MainForm(id);
		mf.setVisible(true);

	}

}
