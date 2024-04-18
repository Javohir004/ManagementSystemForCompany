package Repository;

import model.Project;
import model.Task;

public class TaskRepository  extends BaseRepository<Task>{

    public Task findByTaskname(String taskName) {
        for (Task pro : data) {
            if(pro.getTaskname().equals(taskName)) {
                return pro;
            }
        }
        return null;
    }
}
