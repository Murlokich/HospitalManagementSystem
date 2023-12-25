package Hospital;

import Hospital.Staff.HospitalStaff;

import java.util.List;
public class HospitalFloor {
    private final int floorNumber;
    private final int capacity;
    private int freeBeds;
    private final List<HospitalStaff> staff;
    private final List<HospitalRoom> rooms;

    public int getFloorNumber() {
        return floorNumber;
    }
    public int getCapacity() {
        return capacity;
    }

    public int getFreeBeds() {
        return freeBeds;
    }

    public int calculateCapacity() {
        int capacity = 0;
        for (HospitalRoom room: rooms) {
            capacity += room.getCapacity();
        }
        return capacity;
    }

    public HospitalFloor(int floorNumber, List<HospitalRoom> rooms, List<HospitalStaff> staff) {
        this.floorNumber = floorNumber;
        this.rooms = rooms;
        this.capacity = calculateCapacity();
        this.freeBeds = capacity;
        this.staff = staff;
    }
}
