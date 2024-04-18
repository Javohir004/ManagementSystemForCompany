package Repository;

import model.Project;
import model.User;

import java.util.ArrayList;

public class ProjectRepository extends BaseRepository<Project>{


    public ArrayList<Project> getAllProjects(){
        ArrayList<Project> projectlist = new ArrayList<>();
        for (Project datum : data) {
            projectlist.add(datum);
        }
        return projectlist;
    }


    public Project findByProjectname(String projectName) {
        for (Project pro : data) {
            if(pro.getProjectname().equals(projectName)) {
                return pro;
            }
        }
        return null;
    }

}
