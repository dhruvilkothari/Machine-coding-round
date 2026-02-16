package Entity;
import Enum.*;

public class ParkingSpot {
    private final int spotId;
    private int spotNumber;
    private Vehicle vehicle;
    private SpotStatus spotStatus;
    private final int floorNumber;
    private int pricePerHour;
    private final SpotType spotType;

    public SpotType getSpotType() {
        return spotType;
    }

    public ParkingSpot(int spotId, int spotNumber, Vehicle vehicle, SpotStatus spotStatus, int floorNumber, int pricePerHour, SpotType spotType) {
        this.spotId = spotId;
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.vehicle = vehicle;
        this.spotStatus = spotStatus;
        this.floorNumber = floorNumber;
        this.pricePerHour = pricePerHour;
    }

    public int getSpotId() {
        return spotId;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public void setSpotStatus(SpotStatus spotStatus) {
        this.spotStatus = spotStatus;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
