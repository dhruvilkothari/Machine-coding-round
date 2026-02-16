package Entity;

import java.time.LocalDateTime;

public class Ticket {
    private final String id;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime localDateTime;

    public Ticket(String id, ParkingSpot parkingSpot) {
        this.id = id;
        this.parkingSpot = parkingSpot;
        this.localDateTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
