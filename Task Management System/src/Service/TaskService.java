package Service;

import Entity.Enum.TaskPriority;
import Entity.Enum.TaskStatus;
import Entity.Task;
import Repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class TaskService {
    private final TaskRepository taskRepository;
    private AtomicLong  taskIdGenerator = new AtomicLong(1);

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask( String title, String description, TaskPriority taskPriority, TaskStatus taskStatus, long assignee, LocalDateTime dueDate){
        Task task =  new Task(taskIdGenerator.incrementAndGet(), title,description,taskPriority,taskStatus,assignee, dueDate);
        taskRepository.save(task);
        return task;
    }

    public List<Task> getUserTasks(Long assignee){
        return taskRepository.getTaskOfUser(assignee);
    }

    public Task updateTask(Long taskId, Long assigneeId, HashMap<Object, Object> changes){
        Task t1 = taskRepository.getById(taskId);
        if(t1==null || !Objects.equals(t1.getAssignee(), assigneeId))return null;
        t1.getLock().lock();
        try{

            for (Object change: changes.keySet()){
                if(change.equals("title")){
                    t1.setTitle((String) changes.get("title"));
                }
                if(change.equals("description")){
                    t1.setDescription((String) changes.get("description"));
                }
                if(change.equals("task_priority")){
                    t1.setTaskPriority((TaskPriority) changes.get("task_priority"));
                }
                if(change.equals("task_status")){
                    t1.setTaskStatus((TaskStatus) changes.get("task_status"));
                }

            }

        }catch (Exception exception){
            System.out.println("Something happened");
        }
        finally {
            t1.getLock().unlock();
        }
        return t1;

    }

}
