package com.hotelmanagement.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginForm extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JLabel lblRegister;
	
	
	/*
	 * CheckBox 
	 * RadioButton
	 * ComboBox (Dropdown)
	 * TextArea
	 * 
	 */

	public LoginForm() {
		// this.setSize(350, 200);
		this.setBounds(400, 200, 350, 240);
		this.setTitle("Login Screen");
		this.setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponent();
	}

	private void initComponent() {
		// initilzing component
		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		txtUsername = new JTextField();
		txtPassword = new JTextField();
		btnLogin = new JButton("Login");
		lblRegister = new JLabel("Register yet register? Click Here");
		lblRegister.setForeground(Color.BLUE);

		setComponentPlacement();
		addingComponent();
		setupListeners();

	}

	// placing & sizing components
	private void setComponentPlacement() {
		lblUsername.setBounds(20, 20, 90, 30);
		txtUsername.setBounds(120, 20, 200, 30);
		lblPassword.setBounds(20, 60, 90, 30);
		txtPassword.setBounds(120, 60, 200, 30);
		btnLogin.setBounds(120, 100, 90, 30);
		lblRegister.setBounds(60, 140, 260, 30);
	}

	// adding component in Frame
	private void addingComponent() {
		this.add(lblUsername);
		this.add(txtUsername);
		this.add(lblPassword);
		this.add(txtPassword);
		this.add(btnLogin);
		this.add(lblRegister);

	}

	// Adding events/listeners
	private void setupListeners() {
		/*
		 * this.addWindowListener(new WindowAdapter() { public void
		 * windowClosing(WindowEvent we) { dispose(); }
		 * 
		 * });
		 */

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onLoginButtonClick();
			}

		});
		
		lblRegister.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				openRegisterPage();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	private void onLoginButtonClick() {
		boolean isValid = true;
		String username = txtUsername.getText().trim();
		String password = txtPassword.getText().trim();

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

}
