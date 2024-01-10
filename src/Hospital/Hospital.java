package Hospital;

import java.util.List;
public final class Hospital extends HospitalizationSpace {
   private final String name, address;
   private final List<HospitalFloor> floors;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }



    public int getNumberOfFloors() {
        return floors.size();
    }

    public HospitalFloor getFloor(int floor) {
        assert(floor > 0 && floor < floors.size());
        return floors.get(floor);
    }

    @Override
    protected int calculateCapacity() {
        int capacity = 0;
        for (HospitalFloor floor : floors) {
            capacity += floor.getCapacity();
        }
        return capacity;
    }

    public Hospital(String name, String address, List<HospitalFloor> floors,
                    int availableBeds) {
        super(availableBeds);
        this.name = name;
        this.address = address;
        this.floors = floors;
    }

    public Hospital(String name, String address, List<HospitalFloor> floors) {
        this.name = name;
        this.address = address;
        this.floors = floors;
    }
}
