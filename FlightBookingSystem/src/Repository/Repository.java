package Repository;

import java.util.List;

public interface Repository<T> {
    public void save(T data);
    public T getById(String id);
    public List<T> getAll();
}
