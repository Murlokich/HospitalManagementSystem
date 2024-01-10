package Hospital;

import Hospital.Staff.HospitalStaff;

import java.util.List;
public class HospitalFloor extends HospitalizationSpace {
    private final int floorNumber;
    private final List<HospitalStaff> staff;
    private final List<HospitalRoom> rooms;

    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    protected int calculateCapacity() {
        int capacity = 0;
        for (HospitalRoom room: rooms) {
            capacity += room.getCapacity();
        }
        return capacity;
    }

    public HospitalFloor(int floorNumber, List<HospitalRoom> rooms, List<HospitalStaff> staff) {
        this.floorNumber = floorNumber;
        this.rooms = rooms;
        this.staff = staff;
    }
}
