package hospital;

import java.util.ArrayList;


public class HospitalFloor {
	
    private final int floorNumber;
    private final ArrayList<HospitalRoom> rooms;

    public int getFloorNumber() {
        return floorNumber;
    }
    
    public ArrayList<HospitalRoom> getRooms() {
    	return rooms;
    }
    
    public HospitalRoom getRoom(int roomNumber) {
    	for (HospitalRoom room: rooms) {
    		if (room.getNumber() == roomNumber) {
    			return room;
    		}
    	}
    	assert(true);
    	return null;
    }
    
    public int getMaxRoomCapacity() {
    	int maxRoomCapacity = 0;
    	for (HospitalRoom room: rooms) {
    		maxRoomCapacity = Math.max(room.getCapacity(), maxRoomCapacity);
    	}
    	return maxRoomCapacity;
    }

    public HospitalFloor(int floorNumber, ArrayList<HospitalRoom> rooms) {
    	this.floorNumber = floorNumber;
        this.rooms = rooms;
    }
}
