package controllers;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui.RoomFiltersToolBar;
import gui.RoomTablePanel;
import hospital.*;

// Performs communication between logic and GUI:
// 1) Is used by RoomFiltersToolBar to execute requests on updating 
// list of rooms on screen (RoomTable).
// 2) Opens patient list from Room Table
public class MainController {
	
	private Hospital hospital;
	private RoomTablePanel panel;
	private RoomFiltersToolBar toolbar;
	
	private void connectToolbarWithTable() {
		toolbar.getApplyButton().addActionListener(e -> {
			executeRequest(toolbar.getRoomFilters());
		});
		
		executeRequest(toolbar.getRoomFilters());
	}
	
	// updates table after ApplyButton with filters is pressed
	private void executeRequest(RoomFilters filters) {
		panel.updateModel(hospital.getSuitableRooms(filters));
	}
	
	// makes possible to see patient list by clicking table
	private void setClickableTable() {
		panel.getTable().addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 2) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      
			      int roomNumber = Integer.parseInt(target.getModel().getValueAt(row, 0).toString());
			      int floorNumber = Integer.parseInt(target.getModel().getValueAt(row, 1).toString()) - 1;
			      HospitalRoom room = hospital.getRoom(roomNumber, floorNumber);
			      panel.displayRoom(room);
			    }
			  }
		});
	}
	
	public MainController(Hospital hospital, RoomTablePanel panel, RoomFiltersToolBar toolbar) {
		this.hospital = hospital;
		this.panel = panel;
		this.toolbar = toolbar;
		connectToolbarWithTable();
		setClickableTable();
	}
}
