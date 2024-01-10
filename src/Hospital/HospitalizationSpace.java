package Hospital;

public abstract class HospitalizationSpace {

    private final int capacity;
    private int availableBeds;
    public int getAvailableBeds() {
        return availableBeds;
    }
    public int getCapacity() {
        return capacity;
    }
    protected abstract int calculateCapacity();  // function for complex objects which have inside
                                                 // other HospitalizationSpace objects
    public boolean addPatient() {  // returns true if patient was successful added
        if (availableBeds == 0) {
            return false;
        }
        availableBeds--;
        return true;
    }

    public boolean removePatient() { // returns true if patient was successful added
        if (availableBeds == capacity) {
            return false;
        }
        availableBeds++;
        return true;
    }

    protected HospitalizationSpace(int capacity, int availableBeds) {
        this.capacity = capacity;
        this.availableBeds = availableBeds;
    }

    protected HospitalizationSpace() {
        this.capacity = calculateCapacity();
        this.availableBeds = capacity;
    }

    protected HospitalizationSpace(int availableBeds) {
        this.capacity = calculateCapacity();
        this.availableBeds = availableBeds;
    }
}
