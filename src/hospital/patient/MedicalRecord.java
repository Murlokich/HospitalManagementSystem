package hospital.patient;

import hospital.staff.Doctor;
import java.time.LocalDate;


public record MedicalRecord(LocalDate date, String diagnosis,
                            String recommendations, Doctor author) {
}
