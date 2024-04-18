package Repository;

import model.Task;
import model.Project;


import java.util.ArrayList;
import java.util.UUID;

public class TaskRepository  extends BaseRepository<Task> {
    public static final TaskRepository taskRepository = new TaskRepository();

 
    public Task findByTaskname(String taskName) {
        for (Task pro : data) {
            if(pro.getTaskname().equals(taskName)) {
                return pro;
            }
        }
        return null;
    }
}
