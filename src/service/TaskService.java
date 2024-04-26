package service;

import repository.TaskRepository;
import model.Task;

import java.util.ArrayList;
import java.util.UUID;

public class TaskService extends BaseService<Task , TaskRepository>{

    public TaskService(TaskRepository repository) {
        super(repository);
    }

    @Override
    public boolean check(Task task) {
        Task taskInDb = repository.findByTaskname(task.getTaskname());
        return  taskInDb != null && taskInDb.getActive();
    }


    public ArrayList<Task> showTask(UUID projectId){
     return repository.showTasks(projectId);
    }

    /** bu yerda faqatgina assign bo'lmagan tasklarni ko'rsatadi **/
    public ArrayList<Task> showTaskUnAssigned(UUID projectId){
        return repository.showTasksUnAssign(projectId);
    }

}
