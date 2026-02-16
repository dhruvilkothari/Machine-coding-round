package Strategy;

import Entity.ParkingSpot;
import Enum.*;

import java.util.List;

public interface ParkingFloorFindingStrategy {
    public ParkingSpot findParking(List<ParkingSpot>parkingSpots, VehicleType vehicleType);
}
