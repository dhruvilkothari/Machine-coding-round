package Entity;

public class BookingInterval {
    private final int start;
    private final int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public BookingInterval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
