package Repository;

import Enomerator.UserActivity;
import model.Project;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class ProjectRepository extends BaseRepository<Project> {

    public ArrayList<Project> showProjectByManager(UUID managerId) {
        ArrayList<Project> projects = new ArrayList<>();
        for (Project project : data) {
            if (Objects.equals(project.getManagerId(),managerId)){
                projects.add(project);
            }

        }
        return projects;
    }

}
