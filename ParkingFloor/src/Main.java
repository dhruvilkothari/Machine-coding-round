import Entity.*;
import Enum.*;
import Strategy.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ParkingFloorFindingStrategy strategy = new NearestParkingSpotStrategy();

        // Floor 1 spots
        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot(1, 1, null, SpotStatus.AVAILABLE, 1, 10, SpotType.CAR_SPOT));
        floor1Spots.add(new ParkingSpot(2, 2, null, SpotStatus.AVAILABLE, 1, 5, SpotType.BIKE_SPOT));

        ParkingFloor floor1 = new ParkingFloor(1, 1, floor1Spots, strategy);

        // Floor 2 spots
        List<ParkingSpot> floor2Spots = new ArrayList<>();
        floor2Spots.add(new ParkingSpot(3, 1, null, SpotStatus.AVAILABLE, 2, 20, SpotType.TRUCK_SPOT));

        ParkingFloor floor2 = new ParkingFloor(2, 2, floor2Spots, strategy);

        List<ParkingFloor> floors = Arrays.asList(floor1, floor2);

        // Get parking lot instance
        ParkingLot parkingLot = ParkingLot.getInstance(floors);

        // Create vehicles
        Vehicle car = new Vehicle("KA01AB1234", VehicleType.CAR);

        // Park vehicle
        Ticket ticket = parkingLot.getParkingSpot(car);
        System.out.println("Car parked: " + (ticket != null));

        // Check status
        System.out.println("Is parked: " + parkingLot.isVehicleAvailable(car));

        // Unpark
        parkingLot.removeVehicle(ticket, "UPI");

        System.out.println("Vehicle removed.");
    }
}
