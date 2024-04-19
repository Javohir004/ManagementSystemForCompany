package service;

import Repository.ProjectRepository;
import model.Project;

import java.util.ArrayList;
import java.util.UUID;

public class ProjectService extends BaseService <Project , ProjectRepository> {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }



    @Override
    public boolean check(Project project) {
        Project projectInDb = repository.findByProjectname(project.getProjectname());
        return  projectInDb != null && projectInDb.getActive();
    }


    public ArrayList<Project> getAllProjects(){
        return repository.getAllProjects();
    }


    public ArrayList<Project> getProject(UUID id){
    return repository.getProject(id);
    }
}
