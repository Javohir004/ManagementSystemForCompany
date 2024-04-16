package service;

import Repository.ProjectRepository;
import model.Project;

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
        return false;
    }
}
