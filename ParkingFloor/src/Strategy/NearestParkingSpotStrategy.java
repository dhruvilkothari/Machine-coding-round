package Strategy;

import Enum.*;
import Entity.ParkingSpot;

import java.util.List;

public class NearestParkingSpotStrategy implements ParkingFloorFindingStrategy{
    @Override
    public ParkingSpot findParking(List<ParkingSpot> parkingSpots, VehicleType vehicleType) {
        for (ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getSpotStatus() ==SpotStatus.AVAILABLE){
                if(vehicleType == VehicleType.CAR && parkingSpot.getSpotType() == SpotType.CAR_SPOT){
                    return parkingSpot;
                }else if(vehicleType == VehicleType.BIKE && parkingSpot.getSpotType() ==SpotType.BIKE_SPOT){
                    return parkingSpot;

                }else if(vehicleType == VehicleType.TRUCK && parkingSpot.getSpotType()==SpotType.TRUCK_SPOT){
                    return  parkingSpot;
                }
            }
        }
        return null;
    }
}
