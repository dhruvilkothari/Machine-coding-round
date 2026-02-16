package Entity;

import java.time.LocalDateTime;

public class Flight {
    private final String id;
    private final String source;
    private final String destination;
    private final String duration;
    private final Airplane airplane;
    private final LocalDateTime departureTime;

    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDuration() {
        return duration;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Flight(String id, String source, String destination, String duration, Airplane airplane, LocalDateTime departureTime) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.airplane = airplane;
        this.departureTime = departureTime;
    }
}
