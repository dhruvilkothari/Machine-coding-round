package Entity;
import Enum.*;
public class Booking {
    private final String id;
    private final String userId;
    private final Flight flight;
    private final BookingStatus bookingStatus;
    private final int price;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Flight getFlight() {
        return flight;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public int getPrice() {
        return price;
    }

    public Seat getSeat() {
        return seat;
    }

    private final Seat seat;

    public Booking(String id, String userId, Flight flight, BookingStatus bookingStatus, int price, Seat seat) {
        this.id = id;
        this.userId = userId;
        this.flight = flight;
        this.bookingStatus = bookingStatus;
        this.price = price;
        this.seat = seat;
    }
}
