package Entity;

import Strategy.ParkingFloorFindingStrategy;
import Enum.*;
import java.util.List;

public class ParkingFloor {
    private int floorId;
    private int floorNumber;
    private List<ParkingSpot>parkingSpots;
    private ParkingFloorFindingStrategy parkingFloorFindingStrategy;

    public ParkingFloor(int floorId, int floorNumber, List<ParkingSpot> parkingSpots, ParkingFloorFindingStrategy parkingFloorFindingStrategy) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
        this.parkingFloorFindingStrategy = parkingFloorFindingStrategy;
    }
    public ParkingSpot findParkingSpot(VehicleType vehicleType){
        return parkingFloorFindingStrategy.findParking(this.parkingSpots, vehicleType);
    }

    public boolean bookParkingSpot(ParkingSpot parkingSpot, Vehicle vehicle){
        synchronized (parkingSpot){
            if(parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE){
                parkingSpot.setVehicle(vehicle);
                parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
                return true;
            }
        }
        return false;
    }

    public void unPark(ParkingSpot parkingSpot){
        synchronized (parkingSpot){
            if(parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE)return;
            parkingSpot.setVehicle(null);
            parkingSpot.setSpotStatus(SpotStatus.AVAILABLE);
        }
    }

    public boolean isVehiclePresent(String licenseNumber){
        for (ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getVehicle().getLicenseNumber().equals(licenseNumber))return true;
        }
        return false;
    }
}
