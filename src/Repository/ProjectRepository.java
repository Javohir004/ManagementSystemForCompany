package Repository;

import model.Project;
import model.User;

import java.util.ArrayList;
import java.util.UUID;

public class ProjectRepository extends BaseRepository<Project>{


    public ArrayList<Project> getAllProjects(){
        ArrayList<Project> projectlist = new ArrayList<>();
        for (Project datum : data) {
            if(datum.isActive()){
            projectlist.add(datum);
            }
        }
        return projectlist;
    }


    public Project findByProjectname(String projectName) {
        for (Project pro : data) {
            if(pro.getProjectname().equals(projectName) && pro.isActive()) {
                return pro;
            }
        }
        return null;
    }

    public ArrayList<Project> getProjectByManagerID(UUID managerId){
        ArrayList<Project> projects = new ArrayList<>();
        for (Project datum : data) {
            if(datum.getManagerId().equals(managerId) && datum.isActive()){
                projects.add(datum);
            }
        }
        return projects;
    }

}
