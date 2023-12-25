package Hospital.Staff;

import Hospital.Patient.Patient;

import java.time.LocalDate;
import java.util.List;
public abstract class Doctor extends HospitalStaff {
    private int workExperienceYears;
    private int personalRoomNumber;
    List<Patient> patients;

    public Doctor(String firstName, String lastName, LocalDate birthDate,
                  int workExperienceYears, int personalRoomNumber) {
        super(firstName, lastName, birthDate);
        this.workExperienceYears = workExperienceYears;
        this.personalRoomNumber = personalRoomNumber;
    }
}
