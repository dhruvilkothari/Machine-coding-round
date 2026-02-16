package Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import Enum.*;
import Strategy.PaymentStrategy;
import Strategy.UpiPaymentStrategy;

public class ParkingLot {
    private static ParkingLot instance;
    private Map<String , Ticket> tickets ;
    private List<ParkingFloor>parkingFloors;
    private PaymentStrategy  paymentStrategy;

    private ParkingLot(List<ParkingFloor>parkingFloors){
        this.parkingFloors = parkingFloors;
        tickets = new ConcurrentHashMap<>();
        paymentStrategy = new UpiPaymentStrategy();
    }
    public static ParkingLot getInstance(List<ParkingFloor>parkingFloors){
        synchronized (ParkingLot.class){
            if(instance == null){
                instance = new ParkingLot(parkingFloors);
            }
            return instance;
        }
    }
    public  synchronized boolean isVehicleAvailable(Vehicle vehicle){
        return tickets.containsKey(vehicle.getLicenseNumber());
    }
    public Ticket getParkingSpot(Vehicle vehicle){

        for (ParkingFloor parkingFloor:  parkingFloors){
            ParkingSpot parkingSpot =  parkingFloor.findParkingSpot(vehicle.getVehicleType());
            if(parkingSpot!=null){
                boolean p  = parkingFloor.bookParkingSpot(parkingSpot, vehicle);
                if(p){
                    Ticket ticket = new Ticket(UUID.randomUUID().toString(), parkingSpot);
                    tickets.put(vehicle.getLicenseNumber(), ticket);
                    return ticket;
                }
                continue;
            }
        }
        return null;
    }
    public void removeVehicle(Ticket ticket, String paymentType){
        if("UPI".equals(paymentType)){
            paymentStrategy = new UpiPaymentStrategy();
        }

        paymentStrategy.pay(100);

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        String license = parkingSpot.getVehicle().getLicenseNumber();

        parkingSpot.setSpotStatus(SpotStatus.AVAILABLE);
        parkingSpot.setVehicle(null);

        tickets.remove(license);
    }

}
