import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationRepository {

    private final Map<String, List<Notification>> store = new ConcurrentHashMap<>();

    public void save(String userId, Notification notification){
        store.computeIfAbsent(userId, k -> new ArrayList<>())
                .add(notification);
    }

    public List<Notification> get(String userId){
        return store.getOrDefault(userId, new ArrayList<>());
    }
}
