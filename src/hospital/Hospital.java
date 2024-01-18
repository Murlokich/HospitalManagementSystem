package hospital;

import java.util.List;
import java.util.ArrayList;


public final class Hospital {
   private final String name, address;
   private final List<HospitalFloor> floors;  // floor numbers start from 0
   private int maxRoomCapacity = 0;

   // method sorts out rooms according to provided filters (used for advanced search)
   public ArrayList<HospitalRoom> getSuitableRooms(RoomFilters roomFilters) {
	   ArrayList<HospitalRoom> suitableRooms = new ArrayList<>();
	   ArrayList<HospitalFloor> suitableFloors = new ArrayList<>();
	   // Loop sorts out requested floors
	   for (Integer floorNumber : roomFilters.getFloors()) {
		   HospitalFloor curFloor = floors.get(floorNumber);
		   suitableFloors.add(floors.get(floorNumber));
	   }
	   for (HospitalFloor suitableFloor: suitableFloors) {
		   for (HospitalRoom curRoom: suitableFloor.getRooms()) {
			   if (roomFilters.getMaxCapacity() < curRoom.getCapacity()) {
				   continue;
			   }
			   if (roomFilters.getAvailableBed() == RoomFilters.HasAvailableBedOption.YES
					   && curRoom.getAvailableBeds() == 0) {
				   continue;
			   }
			   if (roomFilters.getAvailableBed() == RoomFilters.HasAvailableBedOption.NO
					   && curRoom.getAvailableBeds() != 0) {
				   continue;
			   }
			   suitableRooms.add(curRoom);
		   }
	   }
	   return suitableRooms;
   }
   
   public String getName() {
       return name;
   }

   public String getAddress() {
       return address;
   }

    public int getNumberOfFloors() {
        return floors.size();
    }
    
    public int getMaxRoomCapacity() {
    	return maxRoomCapacity;
    }
    
    public HospitalRoom getRoom(int roomNumber, int floorNumber) {
    	return floors.get(floorNumber).getRoom(roomNumber);
    }

    public Hospital(String name, String address, List<HospitalFloor> floors) {
        this.name = name;
        this.address = address;
        this.floors = floors;
        for (HospitalFloor floor: floors) {
        	maxRoomCapacity = Math.max(floor.getMaxRoomCapacity(), maxRoomCapacity);
        }
    }
}
