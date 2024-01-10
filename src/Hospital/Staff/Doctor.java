package Hospital.Staff;

import Hospital.Patient.Patient;

import java.time.LocalDate;

public abstract class Doctor extends HospitalStaff {

    public Doctor(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }
}
