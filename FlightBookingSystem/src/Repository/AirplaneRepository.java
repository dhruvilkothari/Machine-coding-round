package Repository;

import Entity.Airplane;
import Entity.Seat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirplaneRepository implements Repository<Airplane> {
    private Map<String, Airplane>airplanes = new HashMap<>();
    @Override
    public void save(Airplane data) {
        airplanes.putIfAbsent(data.getId(), data);

    }

    @Override
    public Airplane getById(String id) {
        return airplanes.getOrDefault(id, null);
    }

    @Override
    public List<Airplane> getAll() {
        return airplanes.values().stream().toList();
    }
}
