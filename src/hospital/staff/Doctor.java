package hospital.staff;

import java.time.LocalDate;


public class Doctor extends HospitalStaff {

    public Doctor(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }
}
