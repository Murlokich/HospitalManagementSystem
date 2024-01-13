package GUI;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	
    public GUI() {
    	JFrame frame = new JFrame();
    	frame.setTitle("Hospital Management System (HMS)");
    	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);  // Defining the size of the window after resizing
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizing the size of the window
        frame.setResizable(true);
        
        JPanel roomDisplayOptions = new JPanel();
        frame.getContentPane().add(roomDisplayOptions, BorderLayout.WEST);
        roomDisplayOptions.setLayout(new BoxLayout(roomDisplayOptions, BoxLayout.Y_AXIS));
        
        JLabel floorChooserLabel = new JLabel("Floor(s):");
        floorChooserLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        floorChooserLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomDisplayOptions.add(floorChooserLabel);
        
        JPanel floorChooser = new JPanel();
        floorChooser.setLayout(new BoxLayout(floorChooser, BoxLayout.Y_AXIS));
        List<JCheckBox> floorCheckboxes = new ArrayList<>();
        int[] floors = {1, 2, 3, 4, 5};
        
        for (int floor: floors) {
        	JCheckBox floorBox = new JCheckBox(Integer.toString(floor));
        	floorBox.setFont(new Font("Dialog", Font.BOLD, 15));
        	floorChooser.add(floorBox);
        	floorCheckboxes.add(floorBox);
        }
        roomDisplayOptions.add(floorChooser);       
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        GUI mainWindow = new GUI();
    }
}
