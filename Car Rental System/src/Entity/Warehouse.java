package Entity;

import Strategy.LowestPriceSearchStrategy;
import Strategy.SearchStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;


public class Warehouse {

    private final Long id;
    private final String name;

    private List<Car> cars;

    private final Map<Long, List<BookingInterval>> bookingIntervals;
    private final Map<Long, Booking> bookings;

    private SearchStrategy searchStrategy;

    private final Map<String, ReentrantLock> locks;
    private final Map<String, Long> lockOwner;

    private final AtomicLong bookingIdGenerator = new AtomicLong(1);

    public Warehouse(Long id, String name, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;

        this.bookingIntervals = new ConcurrentHashMap<>();
        this.bookings = new ConcurrentHashMap<>();
        this.locks = new ConcurrentHashMap<>();
        this.lockOwner = new ConcurrentHashMap<>();
    }

    /* ---------------- SEARCH ---------------- */

    public List<Car> findCar(CarType carType,
                             BookingInterval bookingInterval,
                             SearcStrategyEnum strategyEnum) {

        if (strategyEnum == SearcStrategyEnum.LOWEST) {
            searchStrategy = new LowestPriceSearchStrategy();
        }

        List<Car> available = searchStrategy.findCar(carType, bookingInterval, cars);
        List<Car> results = new ArrayList<>();

        for (Car car : available) {

            List<BookingInterval> intervals =
                    bookingIntervals.getOrDefault(car.getId(), Collections.emptyList());

            boolean free = true;

            for (BookingInterval existing : intervals) {
                if (isOverlap(existing, bookingInterval)) {
                    free = false;
                    break;
                }
            }

            if (free) results.add(car);
        }

        return results;
    }

    /* ---------------- BOOK ---------------- */

    public Booking bookCar(Car car, Long userId, BookingInterval interval) {

        String key = slotKey(car.getId(), interval);

        ReentrantLock lock = locks.computeIfAbsent(key, k -> new ReentrantLock());

        if (!lock.tryLock()) {
            return null; // someone else booking
        }

        // IMPORTANT — double check overlap inside lock
        List<BookingInterval> existing =
                bookingIntervals.getOrDefault(car.getId(), new ArrayList<>());

        for (BookingInterval e : existing) {
            if (isOverlap(e, interval)) {
                lock.unlock();
                return null;
            }
        }

        lockOwner.put(key, userId);

        long bookingId = bookingIdGenerator.getAndIncrement();

        Booking booking = new Booking(
                bookingId,
                userId,
                this.id,
                car.getId(),
                interval,
                car.getPricePerDay() * (interval.getEnd() - interval.getStart()),
                BookingStatus.PENDING
        );

        bookings.put(bookingId, booking);
        return booking;
    }

    /* ---------------- PAY ---------------- */

    public void pay(Long bookingId) {

        Booking booking = bookings.get(bookingId);
        if (booking == null) throw new RuntimeException("Booking not found");

        String key = slotKey(booking.getCarId(), booking.getBookingInterval());

        Long owner = lockOwner.get(key);

        if (owner == null || !owner.equals(booking.getUserId())) {
            throw new RuntimeException("User does not hold lock");
        }

        booking.setStatus(BookingStatus.CONFIRMED);

        bookingIntervals
                .computeIfAbsent(booking.getCarId(), k -> new ArrayList<>())
                .add(booking.getBookingInterval());

        ReentrantLock lock = locks.get(key);
        if (lock != null && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }

        lockOwner.remove(key);
    }

    /* ---------------- HELPERS ---------------- */

    private boolean isOverlap(BookingInterval a, BookingInterval b) {
        return b.getStart() < a.getEnd() && b.getEnd() > a.getStart();
    }

    private String slotKey(Long carId, BookingInterval i) {
        return carId + ":" + i.getStart() + ":" + i.getEnd();
    }

    public Long getId() {
        return  this.id;
    }
}