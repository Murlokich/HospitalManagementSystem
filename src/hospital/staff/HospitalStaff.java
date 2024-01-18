package hospital.staff;

import java.time.LocalDate;


public abstract class HospitalStaff {
    private static int freeId = 0;
    private int id;
    private String firstName, lastName;
    private LocalDate birthDate;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public HospitalStaff(String firstName, String lastName, LocalDate birthDate) {
        this.id = freeId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
