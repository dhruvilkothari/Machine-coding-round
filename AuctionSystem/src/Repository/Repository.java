package Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class  Repository<T> {
    public Map<Long, T> dataMap = new ConcurrentHashMap<>();

    public abstract T save(T data);
    public  T getById(Long id){
        return dataMap.getOrDefault(id, null);
    }
    public List<T> getAll(){
        return dataMap.values().stream().toList();
    }

}
