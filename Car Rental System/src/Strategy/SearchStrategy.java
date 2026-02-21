package Strategy;

import Entity.BookingInterval;
import Entity.Car;
import Entity.CarType;

import java.util.List;

public interface SearchStrategy {
    public List<Car> findCar(CarType carType, BookingInterval bookingInterval, List<Car>cars);
}
