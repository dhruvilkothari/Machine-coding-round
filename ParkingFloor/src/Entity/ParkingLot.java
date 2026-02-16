package Entity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import Enum.*;
import Strategy.PaymentStrategy;
import Strategy.UpiPaymentStrategy;

public class ParkingLot implements Subject {
    private static ParkingLot instance;
    private Map<String , Ticket> tickets ;
    private List<ParkingFloor>parkingFloors;
    private PaymentStrategy  paymentStrategy;
    private List<Observers>observersList;

    private ParkingLot(List<ParkingFloor>parkingFloors){
        this.parkingFloors = parkingFloors;
        tickets = new ConcurrentHashMap<>();
        paymentStrategy = new UpiPaymentStrategy();
        observersList = new ArrayList<>();
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
        notifyObserver();

        tickets.remove(license);
    }

    @Override
    public void addObserver(Observers observers) {
        observersList.add(observers);
    }

    @Override
    public void removeObserver(Observers observers) {
        observersList.remove(observers);
    }

    @Override
    public void notifyObserver() {
        for (Observers obj: observersList){
            obj.notifyObserver("Parking Lot has new Space");
        }
    }
}
