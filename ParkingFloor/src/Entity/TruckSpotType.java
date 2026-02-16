package Entity;
import Enum.*;
public class TruckSpotType extends ParkingSpot{
    public TruckSpotType(int spotId, int spotNumber, Vehicle vehicle, SpotStatus spotStatus, int floorNumber, int pricePerHour) {
        super(spotId, spotNumber, vehicle, spotStatus, floorNumber, pricePerHour, SpotType.TRUCK_SPOT);
    }
}
