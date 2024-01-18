package gui;

import javax.swing.*;
import java.awt.*;

import user.User;
import controllers.UserController;

public class LoginForm extends JFrame{
	
	UserController userController;
	
	private static JButton loginButton;
	private static JButton createAccountButton;
	private static JTextField loginField;
	private static JTextField passwordField;
	
	public LoginForm(UserController userController) {
		this.userController = userController;
		setLayout(new BorderLayout());
		setTitle("Login form");
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 300);  // Defining the size of the window after resizing
        setResizable(true);
		JPanel pageStartPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel loginFormTitle = new JLabel("Login form (HMS)");
		pageStartPanel.add(loginFormTitle);
		add(pageStartPanel, BorderLayout.PAGE_START);
		
		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBorder(BorderFactory.createCompoundBorder(
		            BorderFactory.createTitledBorder(""),
		            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		GridBagConstraints gbc;
		
		JLabel loginLabel = new JLabel("Login:");
		gbc = createGbc(0, 0);
		centerPanel.add(loginLabel, gbc);
		
		JLabel passwordLabel = new JLabel("Password:");
		gbc = createGbc(0, 1);
		centerPanel.add(passwordLabel, gbc);
		
		loginField = new JTextField(10);
		loginField.setMaximumSize(loginField.getPreferredSize());
		gbc = createGbc(1, 0);
		centerPanel.add(loginField, gbc);
		
		passwordField = new JTextField(10);
		passwordField.setMaximumSize(passwordField.getPreferredSize());
		gbc = createGbc(1, 1);
		centerPanel.add(passwordField, gbc);
		
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		loginButton = new JButton("Login");
		buttonPanel.add(loginButton);
		
		createAccountButton = new JButton("Create new account");
		buttonPanel.add(createAccountButton);
		
		add(buttonPanel, BorderLayout.PAGE_END);
		
		setVisible(true);
	}
	
	protected User.ValidityCheckResult login() {
		String password = passwordField.getText();
		String login = loginField.getText();
		User.ValidityCheckResult loginRes = userController.login(login,  password);
		return loginRes;
	}
	
	protected User.ValidityCheckResult createNewAccount() {
		String login = loginField.getText();
		String password = passwordField.getText();
		User.ValidityCheckResult creationRes = userController.addUser(login, password);
		return creationRes;
	}
	
	// Author of the function: Hovercraft Full Of Eels
	// link: https://stackoverflow.com/questions/9851688/how-to-align-left-or-right-inside-gridbaglayout-cell
	private GridBagConstraints createGbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        gbc.anchor =  GridBagConstraints.WEST;
		gbc.weightx = (x == 0) ? 0.1 : 1.0;
		
		return gbc;
	 }
	
	public JButton getCreateAccountButton() {
		return createAccountButton;
	}
	
	public JButton getLoginButton() {
		return loginButton;
	}
}
