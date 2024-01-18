package hospital;

import java.util.ArrayList;
import hospital.patient.Patient;
import hospital.staff.Doctor;


public class HospitalRoom {
    private final int number;
    private final int floor;
    private final int capacity;
    private int availableBeds;
   
    private Doctor doctor;
    ArrayList<Patient> patients;
    
    public ArrayList<Patient> getPatients() {
    	return patients;
    }
    
    public int getNumber() {
    	return number;
    }
    
    public int getFloor() {
    	return floor;
    }
    
    public int getCapacity() {
    	return capacity;
    }
    
    public int getAvailableBeds() {
    	return availableBeds;
    }
    
    public Doctor getDoctor() {
    	return doctor;
    }
    
    public boolean addPatient(Patient patient) {
    	if (availableBeds == 0) {
    		return false;
    	}
    	patients.add(patient);
		return true;
    }
    
    public HospitalRoom(int number, int floor, int capacity, Doctor doctor, ArrayList<Patient> patients) {
    	this.number = number;
    	this.floor = floor;
    	this.capacity = capacity;
    	this.doctor = doctor;
    	this.patients = patients;
    	assert(patients.size() > capacity);
    	this.availableBeds = capacity - patients.size();
    }

    public HospitalRoom(int number, int floor, int capacity, Doctor doctor) {
        this.capacity = capacity;
        this.availableBeds = capacity;
        this.number = number;
        this.floor = floor;
        this.doctor = doctor;
        this.patients = new ArrayList<>();
    }
}
