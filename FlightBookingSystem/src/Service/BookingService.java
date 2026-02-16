package Service;

import Entity.Booking;
import Entity.Flight;
import Entity.Seat;
import Entity.User;
import Enum.*;
import Repository.BookingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    private Booking bookFlight(Flight flight, User user, List<Seat> seats) {

        List<Seat> lockedSeats = new ArrayList<>();
        int totalPrice = 0;

        try {
            // Step 1: Lock all seats
            for (Seat seat : seats) {
                seat.getReentrantLock().lock();
                lockedSeats.add(seat);

                if (seat.getSeatStatus() != SeatStatus.AVAILABLE) {
                    throw new RuntimeException("Seat " + seat.getId() + " not available");
                }
            }

            // Step 2: Mark seats booked
            for (Seat seat : seats) {
                seat.setSeatStatus(SeatStatus.LOCKED);
                totalPrice += seat.getPrice();
            }

            // Step 3: Create booking
            Booking booking = new Booking(
                    UUID.randomUUID().toString(),
                    user.getUserId(),
                    flight,
                    BookingStatus.PENDING,
                    totalPrice,
                    seats
            );

            bookingRepository.save(booking);
            user.getBookings().add(booking);

            return booking;

        } catch (Exception e) {
            System.out.println("Exception occurred while booking: " + e.getMessage());
            return null;

        } finally {
            // Step 4: Always unlock
            for (Seat seat : lockedSeats) {
                seat.getReentrantLock().unlock();
            }
        }
    }

    public void confirmBooking(String bookingId, PaymentType type) {

        Booking booking = bookingRepository.getById(bookingId);
        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }

        if (booking.getBookingStatus() != BookingStatus.PENDING) {
            throw new RuntimeException("Booking already processed");
        }

        // Payment logic
        processPayment(type, booking.getPrice());

        List<Seat> seats = booking.getSeats();

        // Lock seats during confirmation
        for (Seat seat : seats) {
            seat.getReentrantLock().lock();
        }

        try {
            for (Seat seat : seats) {
                seat.setSeatStatus(SeatStatus.BOOKED);
            }
            booking.setBookingStatus(BookingStatus.CONFIRMED);

            bookingRepository.save(booking); // update

        } finally {
            for (Seat seat : seats) {
                seat.getReentrantLock().unlock();
            }
        }
    }

    private void processPayment(PaymentType type, int price) {
    }


}
