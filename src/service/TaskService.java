package service;

import Repository.TaskRepository;
import model.Project;
import model.Task;

public class TaskService extends BaseService<Task , TaskRepository>{

    public TaskService(TaskRepository repository) {
        super(repository);
    }

    @Override
    public Task mapNullFields(Task original, Task update) {
        return null;
    }

    @Override
    public boolean check(Task task) {
        Task taskInDb = repository.findByTaskname(task.getTaskname());
        return  taskInDb != null && taskInDb.getActive();
    }
}
