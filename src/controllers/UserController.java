package controllers;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import user.User;


public class UserController {
	private ArrayList<User> users;
	
	private boolean isNewUser(String login) {
		for (User user: users) {
			if (login.equals(user.getLogin())) {
				return false;
			}
		}
		return true;
	}
	
	public User.ValidityCheckResult login(String login, String password) {
		User.ValidityCheckResult passwordRes = User.isValidPassword(password);
		if (!passwordRes.isValid()) {
			return passwordRes;
		}
		User.ValidityCheckResult loginRes = User.isValidLogin(login);
		if (!loginRes.isValid()) {
			return loginRes;
		}
		for (User user: users) {
			if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
				return new User.ValidityCheckResult(true);
			}
		}
		return new User.ValidityCheckResult(false, "Wrong login or password!");
	}
	
	public User.ValidityCheckResult addUser(String login, String password) {
		User.ValidityCheckResult passwordRes = User.isValidPassword(password);
		if (!passwordRes.isValid()) {
			return passwordRes;
		}
		User.ValidityCheckResult loginRes = User.isValidLogin(login);
		if (!loginRes.isValid()) {
			return loginRes;
		}
		if (!isNewUser(login)) {
			return new User.ValidityCheckResult(false, "User with this login already exists!");
		}
		User user = new User(login, password);
		user.login();
		users.add(user);
		updateUsersFile(user);
		return new User.ValidityCheckResult(true);
	}
	
	private void updateUsersFile(User user) {
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Resources/users.txt", true));
			String line = user.getId() + " " + user.getLogin() + " " + user.getPassword();
			fileWriter.write(line);
			fileWriter.newLine();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("An error occured during users file openning");
			e.printStackTrace();
		} 
	}
	
	public UserController(ArrayList<User> users) {
		this.users = users;
	}
}
