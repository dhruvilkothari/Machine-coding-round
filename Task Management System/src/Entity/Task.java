package Entity;

import Entity.Enum.TaskPriority;
import Entity.Enum.TaskStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class Task extends Id {

    private String title;
    private String description;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private long assignee;
    private LocalDateTime dueDate;

    public ReentrantLock getLock() {
        return lock;
    }

    private ReentrantLock lock;

    public Task(Long id, String title, String description, TaskPriority taskPriority, TaskStatus taskStatus, long assignee, LocalDateTime dueDate) {
        super(id);
        this.title = title;
        this.description = description;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.lock = new ReentrantLock();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public long getAssignee() {
        return assignee;
    }

    public void setAssignee(long assignee) {
        this.assignee = assignee;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
