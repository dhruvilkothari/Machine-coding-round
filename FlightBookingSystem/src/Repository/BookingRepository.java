package Repository;
import Entity.Booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookingRepository implements Repository<Booking>{
    private Map<String, Booking>bookings = new HashMap<String, Booking>();
    @Override
    public void save(Booking data) {
        bookings.putIfAbsent(data.getId(), data);
    }

    public Booking getByUserId(String userId){
         Optional<Booking> bookingOptional = bookings.values().stream().filter(booking -> booking.getUserId().equals(userId)).findFirst();
        return bookingOptional.orElse(null);
    }

    @Override
    public Booking getById(String id) {
        return null;
    }

    @Override
    public List<Booking> getAll() {
        return bookings.values().stream().toList();
    }
}
