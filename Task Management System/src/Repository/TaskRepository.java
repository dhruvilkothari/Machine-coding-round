package Repository;

import Entity.Task;

import java.util.List;
import java.util.Objects;

public class TaskRepository extends Repository<Task> {
    public List<Task> getTaskOfUser(Long assignee) {

        return getAll()
                .stream().filter(task -> Objects.equals(task.getAssignee(), assignee))
                .toList();
    }


}
