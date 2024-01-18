package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import hospital.HospitalRoom;
import hospital.patient.Patient;

public class RoomTablePanel extends JScrollPane {
	
	private static JTable roomsTable = new JTable();
	
	public RoomTablePanel() {
		super(roomsTable);
		roomsTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));
		roomsTable.setFont(new Font("Plain", Font.BOLD, 20));
		roomsTable.setShowVerticalLines(false);
		roomsTable.getTableHeader().setReorderingAllowed(false);  // prevents possibility of dragging columns
		roomsTable.setFillsViewportHeight(true);
        roomsTable.setRowHeight(80);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	
	// replaces list of rooms being displayed according to provided array
	public void updateModel(ArrayList<HospitalRoom> roomsToDisplay) {
		final int columns = 5;
		Object data[][] = new Object[roomsToDisplay.size()][columns];
		for (int i = 0; i < roomsToDisplay.size(); i++) {
			HospitalRoom room = roomsToDisplay.get(i);
			data[i][0] = room.getNumber();
			data[i][1] = room.getFloor() + 1;
			data[i][2] = room.getAvailableBeds();
			data[i][3] = room.getCapacity();
			String doctorTitle = "Dr. " + room.getDoctor().getLastName()
					+ " " +  room.getDoctor().getFirstName().charAt(0) + ".";
			data[i][4] = doctorTitle;
		}
		RoomTable table = new RoomTable(data);
		roomsTable.setModel(table);
		
		// Center alignment for each cell
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		for (int i = 0; i < columns; i++){
	        roomsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    }
	}
	
	public JTable getTable() {
		return roomsTable;
	}
	
	// displays list of patients in provided room
	public void displayRoom(HospitalRoom room) {
		Frame frame = new JFrame();
		JTextArea patientData = new JTextArea();
		ArrayList<Patient> patients = room.getPatients();
		for (Patient patient: patients) {
			patientData.append(patient.toString());
		}
		patientData.setFont(new Font("Serif", Font.BOLD, 20));
		patientData.setEditable(false);
		frame.add(patientData, BorderLayout.CENTER);
		
		JButton addPatient = new JButton("Add patient");
		addPatient.addActionListener(e -> {
			String fullName = JOptionPane.showInputDialog("Enter patients full name separated with space, starting with last name:");
			String[] names = fullName.split("\\s+");
			if (names.length != 2) {
				JOptionPane.showMessageDialog(null, "Full name must consist of 2 words separated with 1 space. Try again", 
						"Input doesn't fit the form", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String lastName = names[0], firstName = names[1];
			String hospitalizationReason = JOptionPane.showInputDialog("Enter hospitalization reason:");
			Patient patient = new Patient(lastName, firstName,
					hospitalizationReason, room.getNumber());
			room.addPatient(patient);
			patientData.append(patient.toString());
			try {
				BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Resources/patients.txt", true));
				String rec = lastName + " " + firstName + " " + room.getNumber() 
						+ "\n" + hospitalizationReason;
				fileWriter.write(rec);
				fileWriter.newLine();
				fileWriter.close();
			} catch (IOException ex) {
				System.out.println("An error occured during users file openning");
				ex.printStackTrace();
			} 
		});
		
		frame.add(addPatient, BorderLayout.PAGE_END);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
