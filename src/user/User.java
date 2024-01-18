package user;

import java.util.regex.Pattern;


public class User {

    private static int idCounter = 0;
    private final int id;
    private final String login, password;
    private boolean logged = false;
    
    static public class ValidityCheckResult {
    	private boolean valid;
    	private String error;
    	
    	public boolean isValid() {
    		return valid;
    	}
    	
    	public String getError() {
    		return error;
    	}
    	
    	public ValidityCheckResult(boolean valid) {
    		this.valid = valid;
    		this.error = null;
    	}
    	
    	public ValidityCheckResult(boolean valid, String error) {
    		this.valid = valid;
    		this.error = error;
    	}
    }
    
    public int getId() {
    	return id;
    }
    
    public String getLogin() {
    	return login;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public boolean isLogged() {
    	return logged;
    }
    
    public void login() {
    	logged = true;
    }
    
    public void logout() {
    	logged = false;
    }
    
    public static ValidityCheckResult isValidPassword(String password) {
    	
        Pattern hasUpperCase = Pattern.compile("[A-Z]");
        Pattern hasLowerCase = Pattern.compile("[a-z]");
        Pattern hasDigit = Pattern.compile("[0-9]");
        Pattern hasSpecialCharacter = Pattern.compile("[!@#$&*]");
        String error = null;
    	if (password.length() < 8) {
    		error = "Password must be at least 8 characters!";
    		return new ValidityCheckResult(false, error);
    	}
    	if (password.matches("(.*?)\\s(.*?)")) {
    		error = "Password must not contain whitespaces!";
    		return new ValidityCheckResult(false, error);
    	}
    	if (!hasUpperCase.matcher(password).find()) {
    		error = "Password must contain at leas 1 uppercase character!";
    		return new ValidityCheckResult(false, error);
    	}
    	if (!hasLowerCase.matcher(password).find()) {
    		error = "Password must contain at least 1 lowercase character!";
    		return new ValidityCheckResult(false, error);
    	}
    	if (!hasDigit.matcher(password).find()) {
    		error = "Password must contain at least 1 digit!";
    		return new ValidityCheckResult(false, error);
    	}
    	if (!hasSpecialCharacter.matcher(password).find()) {
    		error = "Password must contain at least 1 special character: !@#$&*";
    		return new ValidityCheckResult(false, error);
    	}
    	return new ValidityCheckResult(true);
    }
    
    public static ValidityCheckResult isValidLogin(String login) {
    	String error = null;
    	if (login.length() < 8) {
    		error = "Login must be at least 8 characters!";
    		return new ValidityCheckResult(false, error);
    	}
    	if (login.matches("(.*?)\\s(.*?)")) {
    		error = "Login must not contain whitespaces!";
    		return new ValidityCheckResult(false, error);
    	}
    	return new User.ValidityCheckResult(true);
    }
    
    public User(int id, String login, String password) {
    	this.id = id;
    	if (id >= idCounter) {
    		idCounter = id + 1;
    	}
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        id = idCounter++;
    }
}
