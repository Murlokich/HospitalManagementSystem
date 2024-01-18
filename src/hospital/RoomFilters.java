package hospital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class RoomFilters {
	private Set<Integer> floors = new HashSet<>();
	private int maxCapacity;
	private HasAvailableBedOption availableBed;
	
	public static enum HasAvailableBedOption {
		YES, NO, BOTH,
	}
	
	public void addFloor(int floor) {
		floors.add(floor);
	}
	
	public void removeFloor(int floor) {
		floors.remove(floor);
	}
	
	public ArrayList<Integer> getFloors() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.addAll(floors);
		return arrayList;
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	public HasAvailableBedOption getAvailableBed() {
		return availableBed;
	}
	
	public void setAvailableBed(HasAvailableBedOption availableBed) {
		this.availableBed = availableBed;
	}
	
	public RoomFilters(int maxCapacity, HasAvailableBedOption availableBed) {
		this.maxCapacity = maxCapacity;
		this.availableBed = availableBed;
	}
	
	public RoomFilters(ArrayList<Integer> floors, int maxCapacity, HasAvailableBedOption availableBed) {
		this.floors.addAll(floors);
		this.maxCapacity = maxCapacity;
		this.availableBed = availableBed;
	}
}
