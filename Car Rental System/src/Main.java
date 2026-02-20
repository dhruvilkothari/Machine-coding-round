package Main;

import Entity.*;
import Entity.Enum.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // ---------- Cars ----------
        Car car1 = new Car(1L, "Swift", CarType.ECONOMICAL, 1000);
        Car car2 = new Car(2L, "City", CarType.SEDAN, 2000);
        Car car3 = new Car(3L, "BMW", CarType.LUXURY, 5000);

        List<Car> cars = List.of(car1, car2, car3);

        // ---------- Warehouse ----------
        Warehouse warehouse = new Warehouse(1L, "Bangalore Hub", new ArrayList<>(cars));

        // ---------- Booking interval ----------
        BookingInterval interval = new BookingInterval(1, 5);

        // ---------- Search ----------
        List<Car> results = warehouse.findCar(
                CarType.ECONOMICAL,
                interval,
                SearcStrategyEnum.LOWEST
        );

        System.out.println("Search Results:");
        results.forEach(c -> System.out.println(c.getName()));

        Car selected = results.get(0);

        // ---------- MULTITHREAD BOOKING TEST ----------
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable user1 = () -> {
            Booking booking = warehouse.bookCar(selected, 101L, interval);
            if (booking != null) {
                System.out.println("User1 booked → " + booking.getId());
                warehouse.pay(booking.getId());
                System.out.println("User1 paid");
            } else {
                System.out.println("User1 failed booking");
            }
        };

        Runnable user2 = () -> {
            Booking booking = warehouse.bookCar(selected, 202L, interval);
            if (booking != null) {
                System.out.println("User2 booked → " + booking.getId());
                warehouse.pay(booking.getId());
                System.out.println("User2 paid");
            } else {
                System.out.println("User2 failed booking");
            }
        };

        executor.submit(user1);
        executor.submit(user2);

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Done");
    }
}