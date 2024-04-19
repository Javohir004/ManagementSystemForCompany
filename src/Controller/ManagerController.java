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
        String prjoectNAme = scanStr.nextLine();

        if (projectService.add(new Project(prjoectNAme, currentUser.getId())) != 1) {
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
        System.out.println("This project don't live any more !!!");

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
        System.out.println("Successfully changed !!!");

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

            if (userService.add(new User(name, username, password, userRole , currentUser.getId() , null)) != 1) {
                System.out.println("This user already created !!!");
            }
            System.out.println("Employer added !!!");
        }
    }


    public static void deleteEmployer() {
        ArrayList<User> users = showEmployeebyManagerId();

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= users.size()) {
            System.out.println("Something went wrong !!!");
            return;
        }

        User user = users.get(index);
        userService.delete(user.getId());
        System.out.println("Successfully deleted !!!");
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
        String taskname = scanStr.nextLine();

        taskService.add(new Task(taskname, TaskStatus.CREATED,null,project.getId()));
        System.out.println("Successfully created !!! ");

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
     ArrayList<Task> list = showTasks();

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= list.size()) {
            System.out.println("Something went wrong !!!");
            return ;
        }

        Task task = list.get(index);

        System.out.print("Enter task name : ");
        String taskname = scanStr.nextLine();

        taskService.update(task.getId(),new Task(taskname,TaskStatus.CREATED,null,task.getProjectId()));
        System.out.println("Successfully updated !!! ");

    }

    public static void deleteTask(){
        ArrayList<Task> list = showTasks();

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= list.size()) {
            System.out.println("Something went wrong !!!");
            return ;
        }

        Task task = list.get(index);
        taskService.delete(task.getId());
        System.out.println("Successfully deleted !!!");
    }


    public static void assignTask(){
        ArrayList<Task> taskList = showTaskswithAssign();

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= taskList.size()) {
            System.out.println("Something went wrong !!!");
            return ;
        }

        Task task = taskList.get(index);

        /** Bu yerda shu manager ga tegishli employerlar chaqirildi **/

        ArrayList<User> Ishchilar = showEmployeebyManagerId();

        System.out.print("Choose the index : ");
        int h = scanNum.nextInt() - 1;

        if (h < 0 || h >= Ishchilar.size()) {
            System.out.println("Something went wrong !!!");
            return ;
        }

        User user = Ishchilar.get(h);
        task.setAssignTask(user.getId());
        System.out.println("Finally i am  done !!!");
    }


    public static ArrayList<User> showEmployeebyManagerId(){
        ArrayList<User> employee = userService.showEmployersByManager(currentUser.getId());
        int i=0;
        for (User user : employee) {
            System.out.println(++i + " - " + user.getUsername() + " -- " + user.getRole());
        }
        return employee;
    }


    public static ArrayList<Task>  showTaskswithAssign(){
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

        ArrayList<Task>tasks = taskService.showTaskWithAssigned(project.getId());

        int j=0;
        for (Task task : tasks) {
            System.out.println(++j + " - " + task.getTaskname());
        }
        return tasks;
    }
}
