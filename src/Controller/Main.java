package Controller;

import Repository.BlockRepositroy;
import Repository.ProjectRepository;
import Repository.TaskRepository;
import Repository.UserRepository;
import model.User;
import service.BlockService;
import service.ProjectService;
import service.TaskService;
import service.UserService;

import java.util.Scanner;

public class Main {


    public static UserService userService = new UserService( new UserRepository());
    public static BlockService blockService = new BlockService(new BlockRepositroy());
    public static ProjectService projectService = new ProjectService(new ProjectRepository());
    public static TaskService taskService = new TaskService(new TaskRepository());

    public static User currentUser = null;

    public static Scanner scanStr = new Scanner(System.in);
    public static Scanner scanNum = new Scanner(System.in);

    public static void main(String[] args) {
    welcomeMenu();
    }

    private static void welcomeMenu() {
        while (true) {
            System.out.println("1. Sign in\t2. Sign Up\t0. Exit");
            String command = scanStr.nextLine();

            switch (command) {
                case "1" -> {
                    UserController.signIn();
                }
                case "2" -> {
                    UserController.signUp();
                }
                case "0" -> {
                    System.out.println("thank you for choosing us\n\n");
                    return;
                }
                default -> {
                    System.out.println("Sorry?!");
                }
            }
        }
    }




  public static void  mainMenuUser(){

  }









    private static class UserRepository extends Repository.UserRepository {

    }
}