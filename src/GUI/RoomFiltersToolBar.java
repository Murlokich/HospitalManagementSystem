package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class RoomFiltersToolBar extends JPanel {
	
	static final int LARGE_INVISIBLE_SPACE_HEIGHT = 40;
	static final int SMALL_INVISIBLE_SPACE_HEIGHT = 10;
	
	static JLabel roomFiltersTitle;
	static JLabel floorChooserLabel;
	static JPanel floorChooser;
	static JLabel availableBedsSwitchLabel;
	static JComboBox<String> availableBedSwitch;
	static JLabel roomCapacitySliderLabel;
	static JSlider roomCapacitySlider;
	static JButton applyButton;
	
	
	public RoomFiltersToolBar() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		addLargeInvisibleSpace();
        addLargeInvisibleSpace();
        
        createRoomFiltersTitle();
        createFloorChooserLabel();
        createFloorChooser();
        createAvailableBedsSwitchLabel();
        createAvailableBedOptions();
        createRoomCapacitySliderLabel();
        createRoomCapacitySlider();
        createApplyButton();
	}
	
	private void addSmallInvisibleSpace() {
    	add(Box.createRigidArea(new Dimension(0, SMALL_INVISIBLE_SPACE_HEIGHT)));
    }
    
    private void addLargeInvisibleSpace() {
    	add(Box.createRigidArea(new Dimension(0, LARGE_INVISIBLE_SPACE_HEIGHT)));
    }
    
    private void createRoomFiltersTitle() {
    	roomFiltersTitle = new JLabel("Hospital room filter:");
        roomFiltersTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        roomFiltersTitle.setFont(new Font("Dialog", Font.BOLD, 30));
        addLargeInvisibleSpace();
        add(roomFiltersTitle);
        addSmallInvisibleSpace();
    }
    
    private void createFloorChooserLabel() {
    	floorChooserLabel = new JLabel("Floor(s):");
        floorChooserLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        floorChooserLabel.setHorizontalAlignment(SwingConstants.LEFT);
        floorChooserLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addSmallInvisibleSpace();
        add(floorChooserLabel);
    }
    
    private void createFloorChooser() {
        floorChooser = new JPanel();
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
        addSmallInvisibleSpace();
        add(floorChooser);
    }
    
    private void createAvailableBedsSwitchLabel() {
        availableBedsSwitchLabel = new JLabel("Available beds: ");
        availableBedsSwitchLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        availableBedsSwitchLabel.setHorizontalAlignment(SwingConstants.LEFT);
        availableBedsSwitchLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addLargeInvisibleSpace();
        add(availableBedsSwitchLabel);
    }
    
    private void createAvailableBedOptions() {
    	String[] availableBedOptions = {"Yes", "No", "Both"};
        availableBedSwitch = new JComboBox<String>(availableBedOptions);
        availableBedSwitch.setAlignmentX(Component.LEFT_ALIGNMENT);
        availableBedSwitch.setMaximumSize(new Dimension(Integer.MAX_VALUE,
        								availableBedSwitch.getMinimumSize().height));
        addSmallInvisibleSpace();
        add(availableBedSwitch);
    }
    
    private void createRoomCapacitySliderLabel() {
        roomCapacitySliderLabel = new JLabel("Maximum capacity: ");
        roomCapacitySliderLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        roomCapacitySliderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomCapacitySliderLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        addLargeInvisibleSpace();
        add(roomCapacitySliderLabel);
    }
    
    private void createRoomCapacitySlider() {
    	final int MAX_CAPACITY = 5, MIN_CAPACITY = 1;
        roomCapacitySlider = new JSlider(MIN_CAPACITY, MAX_CAPACITY, MIN_CAPACITY);
        roomCapacitySlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        roomCapacitySlider.setPaintTrack(true);
        roomCapacitySlider.setPaintTicks(true);
        roomCapacitySlider.setPaintLabels(true);
        roomCapacitySlider.setMajorTickSpacing(1);
        addSmallInvisibleSpace();
        add(roomCapacitySlider);
    }
    
    private void createApplyButton() {
    	applyButton = new JButton("Apply");
        Dimension maxSize = new Dimension(100, 50);
        applyButton.setMaximumSize(maxSize);
        addLargeInvisibleSpace();
        add(applyButton);
    }
}
