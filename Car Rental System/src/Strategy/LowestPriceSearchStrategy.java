package Strategy;

import Entity.BookingInterval;
import Entity.Car;
import Entity.CarType;

import java.util.List;

public class LowestPriceSearchStrategy implements SearchStrategy {

    @Override
    public List<Car> findCar(CarType carType, BookingInterval bookingInterval, List<Car>cars) {

      return cars.stream()
                .filter(car -> car.getCarType()==carType)

                .sorted((o1, o2) -> o1.getPricePerDay()- o2.getPricePerDay())
                .toList();

    }
}
