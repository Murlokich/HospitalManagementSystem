package Hospital.Patient;

import Hospital.Staff.Doctor;
import java.time.LocalDate;
public record MedicalRecord(LocalDate date, String diagnosis,
                            String recommendations, Doctor author) {
}
