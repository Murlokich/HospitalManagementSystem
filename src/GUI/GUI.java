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
        
        final int SPACE_AFTER_COMPONENT_HEIGHT = 40;
        final int SPACE_AFTER_LABEL_HEIGHT = 10;
        
        JLabel floorChooserLabel = new JLabel("Floor(s):");
        floorChooserLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        floorChooserLabel.setHorizontalAlignment(SwingConstants.LEFT);
        floorChooserLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        roomDisplayOptions.add(Box.createRigidArea(new Dimension(0, SPACE_AFTER_COMPONENT_HEIGHT)));
        roomDisplayOptions.add(floorChooserLabel);
        
        
        JPanel floorChooser = new JPanel();
        floorChooser.setAlignmentX(Component.LEFT_ALIGNMENT);
        floorChooser.setLayout(new BoxLayout(floorChooser, BoxLayout.Y_AXIS));
        List<JCheckBox> floorCheckboxes = new ArrayList<>();
        int[] floors = {1, 2, 3, 4, 5};
        
        for (int floor: floors) {
        	JCheckBox floorBox = new JCheckBox(Integer.toString(floor));
        	floorBox.setFont(new Font("Dialog", Font.BOLD, 15));
        	floorChooser.add(floorBox);
        	floorCheckboxes.add(floorBox);
        }
        roomDisplayOptions.add(Box.createRigidArea(new Dimension(0, SPACE_AFTER_LABEL_HEIGHT)));
        roomDisplayOptions.add(floorChooser);
        
        JLabel availableBedsSwitchLabel = new JLabel("Available beds: ");
        availableBedsSwitchLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        availableBedsSwitchLabel.setHorizontalAlignment(SwingConstants.LEFT);
        availableBedsSwitchLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        roomDisplayOptions.add(Box.createRigidArea(new Dimension(0, SPACE_AFTER_COMPONENT_HEIGHT)));
        roomDisplayOptions.add(availableBedsSwitchLabel);
        
        String[] availableBedOptions = {"Yes", "No", "Both"};
        JComboBox<String> availableBedSwitch = new JComboBox<String>(availableBedOptions);
        availableBedSwitch.setAlignmentX(Component.LEFT_ALIGNMENT);
        availableBedSwitch.setMaximumSize(new Dimension(Integer.MAX_VALUE,
        												availableBedSwitch.getMinimumSize().height));
        roomDisplayOptions.add(Box.createRigidArea(new Dimension(0, SPACE_AFTER_LABEL_HEIGHT)));
        roomDisplayOptions.add(availableBedSwitch);
        
        JLabel roomCapacitySliderLabel = new JLabel("Maximum capacity: ");
        roomCapacitySliderLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        roomCapacitySliderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomCapacitySliderLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        roomDisplayOptions.add(Box.createRigidArea(new Dimension(0, SPACE_AFTER_COMPONENT_HEIGHT)));
        roomDisplayOptions.add(roomCapacitySliderLabel);
        
        final int MAX_CAPACITY = 5, MIN_CAPACITY = 1;
        JSlider roomCapacitySlider = new JSlider(MIN_CAPACITY, MAX_CAPACITY, MIN_CAPACITY);
        roomCapacitySlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        roomCapacitySlider.setPaintTrack(true);
        roomCapacitySlider.setPaintTicks(true);
        roomCapacitySlider.setPaintLabels(true);
        roomCapacitySlider.setMajorTickSpacing(1);
        roomDisplayOptions.add(Box.createRigidArea(new Dimension(0, SPACE_AFTER_LABEL_HEIGHT)));
        roomDisplayOptions.add(roomCapacitySlider);
        
        JButton applyButton = new JButton("Apply");
        Dimension maxSize = new Dimension(100, 50);
        applyButton.setMaximumSize(maxSize);
        roomDisplayOptions.add(Box.createRigidArea(new Dimension(0, SPACE_AFTER_COMPONENT_HEIGHT)));
        roomDisplayOptions.add(applyButton);
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI mainWindow = new GUI();
    }
}
