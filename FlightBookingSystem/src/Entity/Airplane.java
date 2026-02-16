package Entity;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import Enum.*;
public class Airplane {
    private final String id;
    private List<Seat> seats;
    private AirPlaneStatus airPlaneStatus;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public Airplane(String id, List<Seat> seats, AirPlaneStatus airPlaneStatus) {
        this.id = id;
        this.seats = seats;
        this.airPlaneStatus = airPlaneStatus;
    }

    public String getId() {
        return id;
    }

    public AirPlaneStatus getAirPlaneStatus() {
        return airPlaneStatus;
    }
}
