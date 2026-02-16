package Entity;

import Enum.*;
import Enum.SpotStatus;
public class BikeSpotType extends ParkingSpot{
    public BikeSpotType(int spotId, int spotNumber, Vehicle vehicle, int floorNumber, int pricePerHour) {
        super(spotId, spotNumber, vehicle, SpotStatus.AVAILABLE, floorNumber, pricePerHour, SpotType.BIKE_SPOT);
    }
}
