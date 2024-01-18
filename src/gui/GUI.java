package gui;

import javax.swing.*;
import java.awt.*;

import controllers.UserController;
import user.User;


public class GUI {

	static final int LARGE_INVISIBLE_SPACE_HEIGHT = 40;
	static final int SMALL_INVISIBLE_SPACE_HEIGHT = 10;
	
	private LoginForm loginForm;
	private JFrame frame;
	private AccountPanel accountPanel;
	private RoomTablePanel roomTable;
	private RoomFiltersToolBar roomFilters;
	
    public GUI(int floorsNumber, int maxRoomCapacity, UserController userController) {
    	loginForm = new LoginForm(userController);
    	frame = new JFrame();
        setFrameSettings(frame);
        
        roomTable = new RoomTablePanel();
        frame.add(roomTable, BorderLayout.CENTER);
        
        roomFilters = new RoomFiltersToolBar(floorsNumber, maxRoomCapacity);
        frame.add(roomFilters, BorderLayout.WEST);
        
        accountPanel = new AccountPanel();
        frame.add(accountPanel, BorderLayout.EAST);
        
        connectLoginForm();
        connectLogoutButton();
    }
    
    private void setFrameSettings(JFrame frame) {
    	frame.setTitle("Hospital Management System (HMS)");
    	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);  // Defining the size of the window after resizing
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizing the size of the window
        frame.setResizable(true);
    }
    
    private void connectLoginForm() {
    	loginForm.getLoginButton().addActionListener(e -> {
    		User.ValidityCheckResult loginRes = loginForm.login();
    		if (loginRes.isValid()) {
        		loginForm.setVisible(false);
        		frame.setVisible(true);
    		}
    		else {
    			JOptionPane.showMessageDialog(null, loginRes.getError(), 
    					"Creating new account error", JOptionPane.ERROR_MESSAGE);
    		}
    	});
    	
    	loginForm.getCreateAccountButton().addActionListener(e -> {
    		User.ValidityCheckResult creationRes = loginForm.createNewAccount();
    		if (creationRes.isValid()) {
        		loginForm.setVisible(false);
        		frame.setVisible(true);
    		}
    		else {
				JOptionPane.showMessageDialog(null, creationRes.getError(), 
						"Login Error", JOptionPane.ERROR_MESSAGE);
			}
    	});
    }
    
    private void connectLogoutButton() {
    	accountPanel.getLogoutButton().addActionListener(e -> {
    		frame.setVisible(false);
    		loginForm.setVisible(true);
    	});
    }
    
    public RoomTablePanel getRoomTablePanel() {
    	return roomTable;
    }
    
    public RoomFiltersToolBar getRoomFiltersToolBar() {
    	return roomFilters;
    }
}
