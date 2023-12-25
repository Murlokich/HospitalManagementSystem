package Hospital.Patient;

import java.util.List;
import java.time.LocalDate;

public abstract class Patient {
    private static int freeId = 0;
    private int id;
    LocalDate birthDate;
    private String firstName, lastName;
    List<MedicalRecord> medicalHistory;

    public Patient(LocalDate birthDate, String firstName, String lastName,
                   List<MedicalRecord> medicalHistory) {
        this.id = freeId++;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.medicalHistory = medicalHistory;
    }
}
