package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	static final int LARGE_INVISIBLE_SPACE_HEIGHT = 40;
	static final int SMALL_INVISIBLE_SPACE_HEIGHT = 10;
	
    public GUI() {
    	JFrame frame = new JFrame();
        setFrameSettings(frame);
        
        RoomFiltersToolBar roomFilters = new RoomFiltersToolBar();
        frame.getContentPane().add(roomFilters, BorderLayout.WEST);

        frame.setVisible(true);
    }
    
    private void setFrameSettings(JFrame frame) {
    	frame.setTitle("Hospital Management System (HMS)");
    	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);  // Defining the size of the window after resizing
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizing the size of the window
        frame.setResizable(true);
    }

    public static void main(String[] args) {
        GUI mainWindow = new GUI();
    }
}
