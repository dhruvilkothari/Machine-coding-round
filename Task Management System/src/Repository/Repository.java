package Repository;

import Entity.Id;

import java.util.HashMap;
import java.util.List;

public abstract class Repository<T extends Id> {
    public HashMap<Long, T> data = new HashMap<>();

    public void save(T d){
        data.putIfAbsent(d.getId(), d);
    }
    public T getById(Long id){
        return data.getOrDefault(id, null);
    }
    public List<T> getAll(){
        return data.values().stream().toList();
    }

}
