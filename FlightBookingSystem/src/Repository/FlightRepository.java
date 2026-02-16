package Repository;

import Entity.Flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightRepository implements Repository<Flight> {
    private Map<String, Flight>flights = new HashMap<>();
    @Override
    public void save(Flight data) {
        flights.putIfAbsent(data.getId(), data);
    }

    @Override
    public Flight getById(String id) {
        return flights.getOrDefault(id,null);
    }

    @Override
    public List<Flight> getAll() {
        return flights.values().stream().toList();
    }
}
