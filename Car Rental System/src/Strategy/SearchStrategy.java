package Strategy;

import Entity.BookingInterval;
import Entity.Car;
import Entity.Enum.CarType;

import java.util.List;

public interface SearchStrategy {
    public List<Car> findCar(CarType carType, BookingInterval bookingInterval, List<Car>cars);
}
