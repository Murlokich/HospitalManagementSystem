package Hospital;


import Hospital.Patient.Patient;
import java.util.ArrayList;
import java.util.List;


public class HospitalRoom extends HospitalizationSpace{
    private final int number;
    List<Patient> patients;
    @Override
    protected int calculateCapacity() throws HospitalRoomNoCapacityException {
        throw new HospitalRoomNoCapacityException(number);
    }

    public HospitalRoom(int number, int capacity, int availableBeds) {
        // DO NOT call a constructor with no capacity as an argument!
        super(capacity, availableBeds);
        this.number = number;
        this.patients = new ArrayList<>();
    }

    public HospitalRoom(int number, int capacity, int availableBeds, List<Patient> patients) {
        // DO NOT call a constructor with no capacity as an argument!
        super(capacity, availableBeds);
        this.number = number;
        this.patients = patients;
    }
}
