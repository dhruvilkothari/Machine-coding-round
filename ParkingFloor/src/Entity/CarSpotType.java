package Entity;
import Enum.*;
public class CarSpotType extends ParkingSpot{
    public CarSpotType(int spotId, int spotNumber, Vehicle vehicle, SpotStatus spotStatus, int floorNumber, int pricePerHour) {
        super(spotId, spotNumber, vehicle, spotStatus, floorNumber, pricePerHour, SpotType.CAR_SPOT);
    }
}
