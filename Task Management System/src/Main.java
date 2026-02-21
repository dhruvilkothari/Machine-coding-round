import Entity.Enum.TaskPriority;
import Entity.Enum.TaskStatus;
import Entity.Task;
import Repository.TaskRepository;
import Service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        TaskRepository taskRepository = new TaskRepository();

        TaskService taskService = new TaskService(taskRepository);

        Task task = taskService.saveTask("Hello", "World", TaskPriority.HIGH, TaskStatus.BACKLOG, 1l, LocalDateTime.now());
        System.out.println(task);

        List<Task> tasks = taskService.getUserTasks(1l);
        System.out.println(tasks);


    }
}