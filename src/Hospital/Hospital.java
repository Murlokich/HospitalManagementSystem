package Hospital;

import java.util.List;
public final class Hospital {
   private final String name, address;
   private final int capacity;
   private int freeBeds;
   private final List<HospitalFloor> floors;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfFloors() {
        return floors.size();
    }

    public HospitalFloor getFloor(int floor) {
        assert(floor > 0 && floor < floors.size());
        return floors.get(floor);
    }

    public int getFreeBeds() {
        return freeBeds;
    }

    public int calculateCapacity() {
        int capacity = 0;
        for (HospitalFloor floor : floors) {
            capacity += floor.getCapacity();
        }
        return capacity;
    }

    public Hospital(String name, String address, List<HospitalFloor> floors) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        this.capacity = calculateCapacity();
        this.freeBeds = capacity;
    }
}
