package Entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private final String name;
    private List<Booking>bookings;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
