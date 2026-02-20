package Entity;

import Entity.Enum.BookingStatus;

public class Booking {
    private final Long id;
    private final Long userId;
    private final Long wareHouseId;
    private final Long carId;
    private final BookingInterval bookingInterval;
    private final int price;

    public Long getUserId() {
        return userId;
    }

    public Long getWareHouseId() {
        return wareHouseId;
    }

    public Long getCarId() {
        return carId;
    }

    public BookingInterval getBookingInterval() {
        return bookingInterval;
    }

    public int getPrice() {
        return price;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Booking(Long id, Long userId, Long wareHouseId, Long carId, BookingInterval bookingInterval, int price, BookingStatus bookingStatus) {
        this.id = id;
        this.userId = userId;
        this.wareHouseId = wareHouseId;
        this.carId = carId;
        this.bookingInterval = bookingInterval;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    private BookingStatus bookingStatus;

    public Long getId() {
        return this.id;
    }

    public void setStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
