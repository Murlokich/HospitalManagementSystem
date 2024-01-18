package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import hospital.RoomFilters;


public class RoomFiltersToolBar extends JPanel {
	
	private static final int LARGE_INVISIBLE_SPACE_HEIGHT = 40;
	private static final int SMALL_INVISIBLE_SPACE_HEIGHT = 10;
	private final int FLOORS_NUMBER;
	private final int MAX_ROOM_CAPACITY;
	
	private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	
	private static JLabel roomFiltersTitle;
	private static JLabel floorChooserLabel;
	private static JPanel floorChooser;
	private static JLabel availableBedsSwitchLabel;
	private static JComboBox<String> availableBedSwitch;
	private static JLabel roomCapacitySliderLabel;
	private static JSlider roomCapacitySlider;
	private static JButton applyButton;
	
	private RoomFilters filters;
	
	
	public RoomFiltersToolBar(int floorsNumber, int maxRoomCapacity) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		FLOORS_NUMBER = floorsNumber;
		MAX_ROOM_CAPACITY = maxRoomCapacity;
		
		filters = new RoomFilters(getFloorNumbersArrayList(false), MAX_ROOM_CAPACITY, 
						RoomFilters.HasAvailableBedOption.BOTH);
		
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
        
        setBackground(BACKGROUND_COLOR);
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
        
        ArrayList<Integer> floors = getFloorNumbersArrayList(true);
        for (int floor: floors) {
        	JCheckBox floorBox = new JCheckBox(Integer.toString(floor));
        	floorBox.setFont(new Font("Dialog", Font.BOLD, 15));
        	floorBox.setBackground(BACKGROUND_COLOR);
        	floorBox.setSelected(true);
        	floorBox.addItemListener(e -> {
        		if (e.getStateChange() == 1) {
        			filters.addFloor(floor - 1);  // floors array keeps numbers starting 									from 1 (not 0)
        		}
        		else {
        			filters.removeFloor(floor - 1);
        		}
        	});
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
    	final String YES = "Yes", NO = "No", BOTH = "Both";
    	String[] availableBedOptions = {YES, NO, BOTH};
        availableBedSwitch = new JComboBox<String>(availableBedOptions);
        availableBedSwitch.setAlignmentX(Component.LEFT_ALIGNMENT);
        availableBedSwitch.setMaximumSize(new Dimension(Integer.MAX_VALUE,
        								availableBedSwitch.getMinimumSize().height));
        availableBedSwitch.setBackground(BACKGROUND_COLOR);
        availableBedSwitch.addActionListener(e -> {
        	String stringOption = availableBedSwitch.getSelectedItem().toString();
        	System.out.println(stringOption);
        	RoomFilters.HasAvailableBedOption option = RoomFilters.HasAvailableBedOption.BOTH;
        	switch (stringOption) {
        		case YES:
        			option = RoomFilters.HasAvailableBedOption.YES;
        			break;
        		case NO:
        			option = RoomFilters.HasAvailableBedOption.NO;
        			break;
        		case BOTH:
        			option = RoomFilters.HasAvailableBedOption.BOTH;
        			break;
        	}
        	filters.setAvailableBed(option);
        });
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
    	final int MIN_CAPACITY = 1;
        roomCapacitySlider = new JSlider(MIN_CAPACITY, MAX_ROOM_CAPACITY, MIN_CAPACITY);
        roomCapacitySlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        roomCapacitySlider.setPaintTrack(true);
        roomCapacitySlider.setPaintTicks(true);
        roomCapacitySlider.setPaintLabels(true);
        roomCapacitySlider.setMajorTickSpacing(1);
        addSmallInvisibleSpace();
        roomCapacitySlider.setBackground(BACKGROUND_COLOR);
        roomCapacitySlider.addChangeListener(e -> {
        	filters.setMaxCapacity(roomCapacitySlider.getValue());
        });
        add(roomCapacitySlider);
    }
    
    private void createApplyButton() {
    	applyButton = new JButton("Apply");
        Dimension maxSize = new Dimension(100, 50);
        applyButton.setMaximumSize(maxSize);
        addLargeInvisibleSpace();           
        add(applyButton);
    }
    
    // creates an ArrayList with consecutive numbers for all the floors
    // if withShift is true we increase the values by 1 to start floors 
    // from 1 instead of 0 for GUI
	private ArrayList<Integer> getFloorNumbersArrayList(boolean withShift) { 
		// creating a set of floor numbers for default filter settings
		ArrayList<Integer> floors = new ArrayList<>();
		for (int floor = 0; floor < FLOORS_NUMBER; floor++) {
			floors.add(withShift ? floor + 1 : floor);
		}
		return floors;
	}
	
	public JButton getApplyButton() {
		return applyButton;
	}
	
	public RoomFilters getRoomFilters() {
		return filters;
	}
}
