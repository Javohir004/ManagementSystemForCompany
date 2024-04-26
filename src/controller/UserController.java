package controller;

import enomerator.UserRole;
import model.Project;
import model.User;

import java.util.ArrayList;

import static controller.Main.*;

public class UserController {

    public static void signUp() {
        System.out.print("Enter name: ");
        String name = scanStr.nextLine();

        System.out.print("Enter username: ");
        String username = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();

        if (userService.add(new User(name, username, password , UserRole.TESTER)) == 1) {
            System.out.println("- User successfully added!");
        } else {
            System.err.println("- Wrong username or password!");
        }
    }

    public static void signIn() {
        System.out.print("Enter username: ");
        String username = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();

        currentUser = userService.signIn(username, password);
        if (currentUser == null) {
            System.err.println("- Wrong username or password!");
            return;
        }

        if(currentUser.getRole().equals(UserRole.SUPER_ADMIN)){
            System.out.println("Welcome " + currentUser.getUsername().toUpperCase());
            superAdminMenu();
        }

        if(currentUser.getRole().equals(UserRole.MANAGER)){
            System.out.println("Welcome " + currentUser.getUsername().toUpperCase());
            managerMenu();
        }


        if(currentUser.getRole().equals(UserRole.ADMIN)){
        System.out.println("Welcome " + currentUser.getUsername().toUpperCase() + "!\n");
            adminMenu();
        }

    }


    public static void addAdmin(){

        System.out.print("Enter name : ");
        String name = scanStr.nextLine();

        System.out.print("Enter username: ");
        String username = scanStr.nextLine();

        System.out.print("Enter password: ");
        String password = scanStr.nextLine();

        if (userService.add(new User(name, username, password , UserRole.ADMIN)) == 1) {
            System.out.println("New admin added !!!");
        }else {
            System.out.println("This admin already exist !!!");
        }
    }



        public static void removeAdmin(){
       ArrayList<User>userlist = showAdmin();

            System.out.print("Choose the index : ");
            int index = scanNum.nextInt()-1;

            if(index < 0 || index >= userlist.size()){
                System.out.println("Something went wrong !!!");
                return;
            }

            User user = userlist.get(index);
            userService.delete(user.getId());
            System.out.println("Successfully deleted !!!");
        }


        public static ArrayList<User> showAdmin(){
            ArrayList<User>admins = userService.getUsersByRole(UserRole.ADMIN);
            int i=0;
            for (User admin : admins) {
                System.out.println(++i + " - " + admin.getUsername());
            }
            return admins;
        }

    public static ArrayList<Project> showAllpreject(){
    ArrayList<Project> projects = projectService.getAllProjects();
    int i=0;
        for (Project project : projects) {
            User user = userService.findById(project.getManagerId());
            System.out.println(++i + " - " + project.getProjectname() + " " + user.getUsername());
        }
        return projects;
    }

}


