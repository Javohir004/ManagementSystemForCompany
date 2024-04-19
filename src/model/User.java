package model;

import Enomerator.UserRole;

import java.util.UUID;

public class User extends BaseModel {
    private String username;
    private String lastname;

    private String password;
    private UserRole role;
    private UUID managerId;
    private UUID projectId;

    public User(String username, String lastname, String password, UserRole role, UUID managerId, UUID projectId) {
        this.username = username;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.managerId = managerId;
        this.projectId = projectId;
    }


    public User(String username, String lastname, String password, UserRole role) {
        this.username = username;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
    }

    public User(String username, String lastname, String password, UserRole role, UUID projectId) {
        this.username = username;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.projectId = projectId;
    }

    public UUID getManagerId() {
        return managerId;
    }

    public void setManagerId(UUID managerId) {
        this.managerId = managerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public void setProjectId(UUID projectId) {
        this.projectId = projectId;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
