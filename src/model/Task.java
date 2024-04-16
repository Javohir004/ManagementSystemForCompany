package model;

import Enomerator.TaskStatus;

import java.util.UUID;

public class Task extends BaseModel {
 private String taskname;
 private TaskStatus taskStatus;
 private UUID assignTask;

    public Task(String taskname, TaskStatus taskStatus, UUID assignTask) {
        this.taskname = taskname;
        this.taskStatus = taskStatus;
        this.assignTask = assignTask;
    }
    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public UUID getAssignTask() {
        return assignTask;
    }

    public void setAssignTask(UUID assignTask) {
        this.assignTask = assignTask;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskname='" + taskname + '\'' +
                ", taskStatus=" + taskStatus +
                ", assignTask=" + assignTask +
                '}';
    }
}
