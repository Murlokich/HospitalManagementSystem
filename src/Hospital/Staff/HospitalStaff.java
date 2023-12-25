package Hospital.Staff;

import java.time.LocalDate;

public abstract class HospitalStaff {
    private static int freeId = 0;
    private int id;
    private String firstName, lastName;
    private LocalDate birthDate;
    protected final String role;
    private boolean isWorking;
    protected abstract String setRole();
    public HospitalStaff(String firstName, String lastName, LocalDate birthDate) {
        this.id = freeId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        setRole();
    }
}
