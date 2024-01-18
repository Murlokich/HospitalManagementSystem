
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import gui.GUI;
import hospital.Hospital;
import hospital.HospitalFloor;
import hospital.HospitalRoom;
import hospital.patient.Patient;
import hospital.staff.Doctor;
import user.User;
import controllers.MainController;
import controllers.UserController;

public class Application {
	
	private final static String USERS_FILE_PATH = "Resources/users.txt"; 
	private final static String PATIENTS_FILE_PATH = "Resources/patients.txt";
	
	private static ArrayList<User> users = new ArrayList<>();
	private static GUI gui;
	private static UserController userController;
	private static MainController mainController;
	private static Hospital h;
	
	
	public static void main(String[] args) {
		initUsers();
		userController = new UserController(users);
		h = initHospital();
		gui = new GUI(h.getNumberOfFloors(), h.getMaxRoomCapacity(), userController);
		mainController = new MainController(h, gui.getRoomTablePanel(), 					gui.getRoomFiltersToolBar());
	}
	
	static private Hospital initHospital() {
		ArrayList<HospitalFloor> hospitalFloors = new ArrayList<>();
        ArrayList<HospitalRoom> rooms1 = new ArrayList<>();
        ArrayList<HospitalRoom> rooms2 = new ArrayList<>();
        ArrayList<HospitalRoom> rooms3 = new ArrayList<>();
        Doctor doctor1 = new Doctor("Smith", "John", LocalDate.of(1975, 1, 31));
        Doctor doctor2 = new Doctor("Hibbert", "Emanuel", LocalDate.of(1968, 5, 25));
        Doctor doctor3 = new Doctor("Lister", "Joseph", LocalDate.of(1975, 4, 9));
        Doctor doctor4 = new Doctor("Fleming", "Alexander", LocalDate.of(1998, 8, 7));
        Doctor doctor5 = new Doctor("Jenner", "Edward", LocalDate.of(1988, 11, 21));
        Doctor doctor6 = new Doctor("Barnard", "Christian", LocalDate.of(1974, 3, 10));
        
        rooms1.add(new HospitalRoom(101, 0, 5, doctor1));
        rooms1.add(new HospitalRoom(102, 0, 4, doctor1));
        rooms1.add(new HospitalRoom(103, 0, 3, doctor1));
        rooms1.add(new HospitalRoom(1004, 0, 2, doctor1));
        rooms1.add(new HospitalRoom(115, 0, 1, doctor2));
        
        rooms2.add(new HospitalRoom(212, 1, 5, doctor2));
        rooms2.add(new HospitalRoom(209, 1, 4, doctor2));
        rooms2.add(new HospitalRoom(2003, 1, 3, doctor3));
        rooms2.add(new HospitalRoom(282, 1, 2, doctor3));
        rooms2.add(new HospitalRoom(211, 1, 1, doctor3));
        rooms3.add(new HospitalRoom(301, 2, 5, doctor4));
        rooms3.add(new HospitalRoom(309, 2, 4, doctor4));
        rooms3.add(new HospitalRoom(312, 2, 3, doctor5));
        rooms3.add(new HospitalRoom(308, 2, 2, doctor5));
        rooms3.add(new HospitalRoom(329, 2, 1, doctor6));
        ArrayList<HospitalRoom> allRooms = new ArrayList<>();
        allRooms.addAll(rooms1);
        allRooms.addAll(rooms2);
        allRooms.addAll(rooms3);
        
        placePatientsToRooms(allRooms);
        hospitalFloors.add(new HospitalFloor(0, rooms1));
        hospitalFloors.add(new HospitalFloor(1, rooms2));
        hospitalFloors.add(new HospitalFloor(2, rooms3));
        
        return new Hospital("", "", hospitalFloors);
	}
	
	// reads users from file
	static private void initUsers() {
		Scanner fileReader = null;
		try {
			File usersFile = new File(USERS_FILE_PATH);
			if (!usersFile.createNewFile()) {
				fileReader = new Scanner(usersFile);
				while (fileReader.hasNextLine()) {
					String line = fileReader.nextLine();
					String[] splited = line.split("\\s+");
					assert(splited.length == 3);
					int id = Integer.parseInt(splited[0]);
					String login = splited[1], password = splited[2];
					users.add(new User(id, login, password));
				}
			}
		} catch (Exception e) {
			System.out.println("An error occured during file creation");
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
	}
	
	// reads patients from file
	private static ArrayList<Patient> initPatients() {
		ArrayList<Patient> patients = new ArrayList<>();
		Scanner fileReader = null;
		try {
			File patientsFile = new File(PATIENTS_FILE_PATH);
			if (!patientsFile.createNewFile()) {
				fileReader = new Scanner(patientsFile);
				while (fileReader.hasNextLine()) {
					String line = fileReader.nextLine();
					String[] splited = line.split("\\s+");
					assert(splited.length == 3);
					String lastName = splited[0];
					String firstName = splited[1];
					int roomsNumber = Integer.parseInt(splited[2]);
					String hospReason = fileReader.nextLine();
					patients.add(new Patient(lastName, firstName, hospReason , roomsNumber));
				}
			}
		} catch (Exception e) {
			System.out.println("An error occured during file creation");
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return patients;
	}
	
	private static void placePatientsToRooms(ArrayList<HospitalRoom> rooms) {
		ArrayList<Patient> patients = initPatients();
		for (HospitalRoom room: rooms) {
			for (Patient patient: patients) {
				if (room.getNumber() == patient.getRoomNumber()) {
					room.addPatient(patient);
				}
			}
		}
	}
}
