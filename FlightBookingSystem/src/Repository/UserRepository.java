package Repository;

import Entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User>{
    private Map<String, User>users = new HashMap<>();
    @Override
    public void save(User data) {
        users.putIfAbsent(data.getUserId(), data);
    }

    @Override
    public User getById(String id) {
        return users.getOrDefault(id, null);
    }

    @Override
    public List<User> getAll() {
        return users.values().stream().toList();
    }
}
