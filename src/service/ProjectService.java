package service;

import Repository.ProjectRepository;
import model.Project;

import java.util.ArrayList;

public class ProjectService extends BaseService <Project , ProjectRepository> {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }

    @Override
    public Project mapNullFields(Project original, Project update) {
        return null;
    }

    @Override
    public boolean check(Project project) {
        Project projectInDb = repository.findByProjectname(project.getProjectname());
        return  projectInDb != null && projectInDb.getActive();
    }


    public ArrayList<Project> getAllProjects(){
        ArrayList<Project> projects = repository.getAllProjects();
        return projects;
    }
}
