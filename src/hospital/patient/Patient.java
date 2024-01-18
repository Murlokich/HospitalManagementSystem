package hospital.patient;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Patient {
    private static int freeId = 0;
    private final int id;
    private LocalDate birthDate = null;
    private final String firstName, lastName;
    private List<MedicalRecord> medicalHistory = null;
    private String hospitalizationReason = null;

    private int roomNumber = -1, hospitalizationDays = -1;
    private LocalDate hospitalizationDate = null;
    
    @Override
    public String toString() {
    	String res = lastName + " " + firstName + "\n\nHospitalization reason:\n" 
    					+ hospitalizationReason + "\n" + "\n\n";
    	return res;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<MedicalRecord> getMedicalHistory() {
        return medicalHistory;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoom(int roomNumber) {
    	this.roomNumber = roomNumber;
    }

    public int getHospitalizationDays() {
        return hospitalizationDays;
    }

    public LocalDate getHospitalizationDate() {
        return hospitalizationDate;
    }
    
    public Patient(String lastName, String firstName, String hospitalizationReason, int roomNumber) {
    	this.id = freeId++;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.hospitalizationReason = hospitalizationReason;
    	this.roomNumber = roomNumber;
    }

    public Patient(LocalDate birthDate, String firstName, String lastName,
                   List<MedicalRecord> medicalHistory, int roomNumber,
                   int hospitalizationDays, LocalDate hospitalizationDate) {
        this.id = freeId++;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalHistory = medicalHistory;
        this.roomNumber = roomNumber;
        this.hospitalizationDays = hospitalizationDays;
        this.hospitalizationDate = hospitalizationDate;
    }

    public Patient(LocalDate birthDate, String firstName, String lastName,
                   List<MedicalRecord> medicalHistory, int roomNumber,
                   LocalDate hospitalizationDate) {
        this(birthDate, firstName, lastName, medicalHistory, roomNumber, -1, hospitalizationDate);
    }

    public Patient(LocalDate birthDate, String firstName, String lastName,
                   int roomNumber, int hospitalizationDays,
                   LocalDate hospitalizationDate) {
        this(birthDate, firstName, lastName, new ArrayList<>(),
                roomNumber, hospitalizationDays, hospitalizationDate);
    }

    public Patient(LocalDate birthDate, String firstName, String lastName,
                    int roomNumber, LocalDate hospitalizationDate) {
        this(birthDate, firstName, lastName, new ArrayList<>(), roomNumber, -1, hospitalizationDate);
    }
}
