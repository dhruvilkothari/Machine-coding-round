package Entity;
import Enum.*;

import java.util.concurrent.locks.ReentrantLock;

public class Seat {
    private final  String id;
    private SeatType seatType;
    private SeatStatus seatStatus;
    private int price;


    public String getId() {
        return id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public int getPrice() {
        return price;
    }

    public Seat(String id, SeatType seatType, int price) {
        this.id = id;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.price = price;
    }
    public void setSeatStatus (SeatStatus seatStatus){
        this.seatStatus =  seatStatus;
    }

}
