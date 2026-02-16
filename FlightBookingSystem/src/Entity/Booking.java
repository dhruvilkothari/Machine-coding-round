package Entity;
import Enum.*;

import java.util.List;

public class Booking {
    private final String id;
    private final String userId;
    private final Flight flight;
    private  BookingStatus bookingStatus;
    private final int price;
    private final List<Seat>seats;

    public List<Seat> getSeats() {
        return seats;
    }

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
    public Booking(String id, String userId, Flight flight, BookingStatus bookingStatus, int price, List<Seat> seats) {
        this.id = id;
        this.userId = userId;
        this.flight = flight;
        this.bookingStatus = bookingStatus;
        this.price = price;
        this.seats = seats;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus =  bookingStatus;
    }
}
