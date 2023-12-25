package Hospital.Patient;

import java.time.LocalDate;
import java.util.List;

public class HospitalizedPatient extends Patient {
    private int hospitalizationRoom;
    private int hospitalizationDaysTotal;
    private int hospitalizationDaysSpent;

    public HospitalizedPatient(LocalDate birthDate, String firstName,
                               String lastName, List<MedicalRecord> medicalHistory,
                               int hospitalizationRoom, int hospitalizationDaysTotal,
                               int hospitalizationDaysSpent) {
        super(birthDate, firstName, lastName, medicalHistory);
        this.hospitalizationRoom = hospitalizationRoom;
        this.hospitalizationDaysTotal = hospitalizationDaysTotal;
        this.hospitalizationDaysSpent = hospitalizationDaysSpent;
    }
}
