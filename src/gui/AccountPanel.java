package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AccountPanel extends JPanel {
	
	private static JMenuItem logoutButton = new JMenuItem("Logout");
	
	public AccountPanel() {
		setLayout(new GridBagLayout());
        setBackground(Color.white);
        
        final JPopupMenu menu = new JPopupMenu();
        menu.add(logoutButton);
        
        final JButton button = new JButton();
        ImageIcon image = new ImageIcon("Resources/AccountIcon.jpg");
        Image largeAccountIcon = image.getImage();
        Image smallAccountIcon = largeAccountIcon.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(smallAccountIcon));
            
        button.setBorderPainted(false); 
        button.setContentAreaFilled(false); 
        button.setFocusPainted(false); 
        button.setOpaque(false);
       
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		menu.show(button, button.getBounds().x, button.getBounds().y
                       + button.getBounds().height);
            }
        });
            
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(button, gbc);
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(new JLabel(" "), gbc);  // blank JLabel
	}
	
	public JMenuItem getLogoutButton() {
		return logoutButton;
	}
}
