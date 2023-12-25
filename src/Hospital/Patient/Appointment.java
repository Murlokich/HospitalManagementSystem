package Hospital.Patient;

import Hospital.HospitalRoom;
import Hospital.Staff.Doctor;

import java.time.LocalDateTime;

public record Appointment(LocalDateTime appointmentDate, Doctor visitedDoctor,
                          HospitalRoom room){}
