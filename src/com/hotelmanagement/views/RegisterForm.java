package com.hotelmanagement.views;

import javax.swing.*;

import com.hotelmanagement.controller.IRegistration;
import com.hotelmanagement.controller.RegistrationController;
import com.hotelmanagement.model.RegistrationModel;

import java.awt.event.*;

public class RegisterForm extends JFrame implements IRegistration {

	private static final long serialVersionUID = 1L;
	private JLabel lblResturentName;
	private JLabel lblOwnerName;
	private JLabel lblOwnerEmail;
	private JLabel lblPhoneNo;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtResturentName;
	private JTextField txtOwnerName;
	private JTextField txtOwnerEmail;
	private JTextField txtPhoneNo;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLogin;
	private JButton btnRegister;

	private RegistrationModel model;
	private RegistrationController controller;

	public RegisterForm() {
		this.setTitle("Register Form");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(400, 200, 510, 360);
		this.setLayout(null);
		this.setResizable(false);

		model = new RegistrationModel();
		controller = new RegistrationController(this);

		initComponent();
	}

	private void initComponent() {
		lblResturentName = new JLabel("Resturent Name");
		lblOwnerName = new JLabel("Owner Name");
		lblOwnerEmail = new JLabel("Owner Email");
		lblPhoneNo = new JLabel("Phone No.");
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		txtResturentName = new JTextField();
		txtOwnerName = new JTextField();
		txtOwnerEmail = new JTextField();
		txtPhoneNo = new JTextField();
		txtUsername = new JTextField();
		txtPassword = new JPasswordField();
		lblLogin = new JLabel("Already Sign in? Click here...");
		btnRegister = new JButton("Register");

		placeComponent();
		addingComponent();
		setListeners();
	}

	private void placeComponent() {
		lblResturentName.setBounds(20, 20, 120, 30);
		txtResturentName.setBounds(20, 50, 220, 30);
		lblOwnerName.setBounds(270, 20, 120, 30);
		txtOwnerName.setBounds(270, 50, 220, 30);

		lblOwnerEmail.setBounds(20, 80, 90, 30);
		txtOwnerEmail.setBounds(20, 120, 220, 30);
		lblPhoneNo.setBounds(270, 80, 90, 30);
		txtPhoneNo.setBounds(270, 120, 220, 30);

		lblUsername.setBounds(20, 160, 90, 30);
		txtUsername.setBounds(20, 190, 220, 30);
		lblPassword.setBounds(270, 160, 90, 30);
		txtPassword.setBounds(270, 190, 220, 30);

		btnRegister.setBounds(190, 240, 120, 30);
		lblLogin.setBounds(160, 290, 220, 30);
	}

	private void addingComponent() {
		this.add(lblResturentName);
		this.add(txtResturentName);
		this.add(lblOwnerName);
		this.add(txtOwnerName);
		this.add(lblOwnerEmail);
		this.add(txtOwnerEmail);
		this.add(lblPhoneNo);
		this.add(txtPhoneNo);
		this.add(lblUsername);
		this.add(txtUsername);
		this.add(lblPassword);
		this.add(txtPassword);
		this.add(btnRegister);
		this.add(lblLogin);
	}

	private void setListeners() {

		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				onRegisterClick();
			}

		});
	}

	public void onRegisterClick() {
		String email = txtOwnerEmail.getText().toString().trim();
		String resturentName = txtResturentName.getText().toString().trim();
		String ownerName = txtOwnerName.getText().toString().trim();
		String ownerPhone = txtPhoneNo.getText().toString().trim();
		String username = txtUsername.getText().toString().trim();
		String password = new String(txtPassword.getPassword());

		model.setOwnerEmail(email);
		model.setResturentName(resturentName);
		model.setOwnerName(ownerName);
		model.setPhoneNo(ownerPhone);
		model.setUsername(username);
		model.setPassword(password);

		controller.validated(model);

	}

	public static void main(String[] args) {
		RegisterForm rf = new RegisterForm();
		rf.setVisible(true);
	}

	@Override
	public void emailError() {
		JOptionPane.showMessageDialog(this, "Please input valid email", "Invalid Email", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void phoneError() {
		JOptionPane.showMessageDialog(this, "Please input valid phone number", "Invalid Phone No.",
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void resturentNameRequired() {
		JOptionPane.showMessageDialog(this, "Please input resturent name", "Resturent name required",
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void ownerNameRequired() {
		JOptionPane.showMessageDialog(this, "Please input owner name", "Owner name required",
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void passwordRequired() {
		JOptionPane.showMessageDialog(this, "Please input password", "Password required", JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void usernameRequired() {
		JOptionPane.showMessageDialog(this, "Please input username", "Username required", JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void passwordError() {
		JOptionPane.showMessageDialog(this, "Password required atlest 8 character and one digit", "Invalid password",
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void usernameError() {
		JOptionPane.showMessageDialog(this, "Username required alteast 6 characters", "Invalid Username",
				JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void usernameAlreadyExist() {
		JOptionPane.showMessageDialog(this, "Username already exist, Please choose another username",
				"Username already exist", JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void registrationSuccess() {
		JOptionPane.showMessageDialog(this, "Registration successfull",
				"Success", JOptionPane.INFORMATION_MESSAGE);
		this.dispose();
		LoginForm lf = new LoginForm();
		lf.setVisible(true);
	}

	@Override
	public void registrationError() {
		JOptionPane.showMessageDialog(this, "Something went wrong while registring user",
				"Error", JOptionPane.ERROR_MESSAGE);
		
	}

}
