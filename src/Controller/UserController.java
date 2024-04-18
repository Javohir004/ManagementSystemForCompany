package Controller;

import Enomerator.UserRole;
import model.Project;
import model.User;

import java.util.ArrayList;

import static Controller.Main.*;

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
            superAdminMenu();
        }

        System.out.println("Welcome " + currentUser.getUsername().toUpperCase() + "!\n\n");

        mainMenuUser();
    }


    public static void addAdmin(){

        System.out.println("Enter name : ");
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

            System.out.println("Choose the index : ");
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

    public static void showAllpreject(){
    ArrayList<Project> projects = projectService.getAllProjects();
    }

}



