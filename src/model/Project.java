package model;

import java.util.UUID;

public class Project extends BaseModel {
    private String projectName;

    private UUID managerId;

    public Project(String projectName, UUID managerId) {
        this.projectName = projectName;
        this.managerId = managerId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
                "projectName='" + projectName + '\'' +
                ", managerId=" + managerId +
                '}';
    }
}
