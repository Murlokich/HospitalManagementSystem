package Hospital.Patient;

import java.time.LocalDate;
import java.util.List;

public class AppointmentPatient extends Patient {
    List<Appointment> appointments;

    public AppointmentPatient(LocalDate birthDate, String firstName,
                              String lastName, List<MedicalRecord> medicalHistory,
                              List<Appointment> appointments) {
        super(birthDate, firstName, lastName, medicalHistory);
        this.appointments = appointments;
    }
}
