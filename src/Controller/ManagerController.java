package Controller;

import Enomerator.TaskStatus;
import Enomerator.UserRole;
import model.Project;
import model.Task;
import model.User;

import java.util.ArrayList;

import static Controller.Main.*;
import static Controller.UserController.showAllpreject;

public class ManagerController {


    public static void createProject() {
        System.out.print("Enter project name : ");
        String command = scanStr.nextLine();

        if (projectService.add(new Project(command, currentUser.getId())) != 1) {
            System.out.println("This project already created !!!");
        }

        System.out.println("Project successfully created !!! ");
    }

    public static void deleteProject() {
        ArrayList<Project> projects = showAllpreject();

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= projects.size()) {
            System.out.println("Something went wrong !!!");
            return;
        }

        Project project = projects.get(index);
        projectService.delete(project.getId());

    }

    public static void updateProject() {
        ArrayList<Project> projects = showAllpreject();

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= projects.size()) {
            System.out.println("Something went wrong !!!");
            return;
        }

        Project project = projects.get(index);

        System.out.println("Enter new name : ");
        String name = scanStr.nextLine();
        projectService.update(project.getId(), new Project(name, currentUser.getId()));

    }


    public static void addEmployee() {
        System.out.print("Enter name: ");
        String name = scanStr.nextLine();

        System.out.print("Enter username: ");
        String username = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();

        while (true) {
            System.out.println("\t\t1.DEVELOPER_BE    2.DEVELOPER_FE     3.TESTER ");
            System.out.println("\t\t4.LEADER_A          5.LEADER_B ");

            System.out.print("Choose one : ");
            String command = scanStr.nextLine();

            UserRole userRole;

            switch (command) {
                case "1" -> {
                    userRole = UserRole.DEVELOPER_BE;
                }
                case "2" -> {
                    userRole = UserRole.DEVELOPER_FE;
                }
                case "3" -> {
                    userRole = UserRole.TESTER;
                }
                case "4" -> {
                    userRole = UserRole.LEADER_A;
                }
                case "5" -> {
                    userRole = UserRole.LEADER_B;
                }
                default -> {
                    System.out.println("You choose or enter wrong command !!!");
                    return;
                }
            }

            if (userService.add(new User(name, username, password, userRole)) != 1) {
                System.out.println("This user already created !!!");
            }

        }
    }


    public static void deleteEmployer() {
        ArrayList<User> users = showEmployee();

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= users.size()) {
            System.out.println("Something went wrong !!!");
            return;
        }

        User user = users.get(index);
        userService.delete(user.getId());
    }

    public static ArrayList<User> showEmployee() {
        ArrayList<User> emloyers = userService.showEmployers();
        int i = 0;
        for (User emloyer : emloyers) {
            System.out.println(++i + " - " + emloyer.getUsername() + "   " + emloyer.getRole());
        }
        return emloyers;
    }


    public static void createTask() {
        ArrayList<Project> projects = projectService.getProject(currentUser.getId());
        int i = 0;
        for (Project project : projects) {
            System.out.println(++i + " - " + project.getProjectname());
        }

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= projects.size()) {
            System.out.println("Something went wrong !!!");
            return;
        }

        Project project = projects.get(index);

        System.out.print("Enter task name : ");
        String task = scanStr.nextLine();

        taskService.add(new Task(task, TaskStatus.CREATED,null,project.getId()));

    }



    public static ArrayList<Task>  showTasks(){
        ArrayList<Project> projects = projectService.getProject(currentUser.getId());
        int i = 0;
        for (Project project : projects) {
            System.out.println(++i + " - " + project.getProjectname());
        }

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= projects.size()) {
            System.out.println("Something went wrong !!!");
            return null;
        }

        Project project = projects.get(index);

        ArrayList<Task>tasks = taskService.showTask(project.getId());

        int j=0;
        for (Task task : tasks) {
            System.out.println(++j + " - " + task.getTaskname());
        }
        return tasks;
    }


    public static void updateTask(){

    }



}
