package Hospital;

public class HospitalRoomNoCapacityException extends RuntimeException {
    public HospitalRoomNoCapacityException(int number) {
        super("Room number " + number + " had no capacity provided. " +
                "Call only the constructor with directly specified capacity!");
    }
}
