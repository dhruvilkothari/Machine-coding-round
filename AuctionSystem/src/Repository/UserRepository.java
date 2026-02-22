package Repository;

import Entity.User;

public class UserRepository extends Repository<User> {
    @Override
    public User save(User data) {
        dataMap.putIfAbsent(data.getId(), data);
        return  data;
    }
}
