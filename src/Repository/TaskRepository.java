package Repository;

import model.Project;
import model.Task;

import java.util.ArrayList;
import java.util.UUID;

public class TaskRepository  extends BaseRepository<Task>{

    public Task findByTaskname(String taskName) {
        for (Task pro : data) {
            if(pro.getTaskname().equals(taskName)) {
                return pro;
            }
        }
        return null;
    }


    public ArrayList<Task> showTasks(UUID id){
        ArrayList<Task>taskArrayList = new ArrayList<>();
        for (Task datum : data) {
            if(datum.getProjectId().equals(id) && datum.isActive()){
                taskArrayList.add(datum);
            }
        }
        return taskArrayList;
    }

    public ArrayList<Task> showTasksUnAssign(UUID id){
        ArrayList<Task>taskArrayList = new ArrayList<>();
        for (Task datum : data) {
            if(datum.getProjectId().equals(id) && datum.isActive() && datum.getAssignTask() != null){
                taskArrayList.add(datum);
            }
        }
        return taskArrayList;
    }

}
