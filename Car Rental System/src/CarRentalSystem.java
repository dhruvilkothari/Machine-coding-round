import Entity.Booking;
import Entity.BookingInterval;
import Entity.Car;
import Entity.Enum.CarType;
import Entity.Enum.SearcStrategyEnum;
import Entity.Warehouse;

import java.util.HashMap;
import java.util.List;

public class CarRentalSystem {
    private static CarRentalSystem instance;
    private HashMap<Long, Warehouse> warehouses;
    private CarRentalSystem(List<Warehouse>ware){
        this.warehouses = new HashMap<>();
        for (Warehouse warehouse: ware){
            warehouses.putIfAbsent(warehouse.getId(), warehouse);
        }
    }
    public CarRentalSystem getInstance(List<Warehouse>ware){

        synchronized (CarRentalSystem.class){
            if(instance == null){
                instance = new CarRentalSystem(ware);
            }
            return instance;
        }
    }

    public List<Car> getVehicles(CarType carType, BookingInterval bookingInterval, Warehouse warehouse, SearcStrategyEnum searcStrategyEnum){
        return warehouse.findCar( carType, bookingInterval, searcStrategyEnum);
    }

    public Booking bookCar(Warehouse warehouse, Car car, Long userId, BookingInterval bookingInterval){

        Booking booking =  warehouse.bookCar(car, userId, bookingInterval);

        return  booking;
    }

    public void pay(Booking booking, Warehouse warehouse){
        warehouse.pay(booking.getId());
    }

}
