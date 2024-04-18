package model;

import java.util.UUID;

public class Project extends BaseModel {
    private String projectname;

    private UUID managerId;

    public Project(String projectname, UUID managerId) {
        this.projectname = projectname;
        this.managerId = managerId;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public UUID getManagerId() {
        return managerId;
    }

    public void setManagerId(UUID managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectname='" + projectname + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}
