package Controller;

import Enomerator.UserRole;
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

import static Controller.AdminController.*;
import static Controller.UserController.*;

public class Main {


    public static UserService userService = new UserService( new UserRepository());
    public static BlockService blockService = new BlockService(new BlockRepositroy());
    public static ProjectService projectService = new ProjectService(new ProjectRepository());
    public static TaskService taskService = new TaskService(new TaskRepository());

    public static User currentUser = null;

    public static Scanner scanStr = new Scanner(System.in);
    public static Scanner scanNum = new Scanner(System.in);

    public static void main(String[] args) {
    userRole();
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


    public static void superAdminMenu(){
        while (true) {
            System.out.println("1.Add A\t2.Remove A\t3.Show A\t4.All projects\t0. Exit");
            String command = scanStr.nextLine();

            switch (command) {
                case "1" -> {
                addAdmin();
                }
                case "2" -> {
                    removeAdmin();
                }case "3" ->{
                    showAdmin();
                }case "4" ->{
                    showAllpreject();
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



  public static void  adminMenu(){
      while (true) {
          System.out.println("1.Stop A\t2.Restart manager\t3.Show projects\t4.Add manager\t5.Remove manager\t0. Exit");
          String command = scanStr.nextLine();

          switch (command) {
              case "1" -> {
                  stopManager();
              }
              case "2" -> {
                   restartManager();
              }case "3" ->{
                  showAdmin();
              }case "4" ->{
                  addManager();
              }case "5" ->{
                  removeManager();
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

  public static void managerMenu(){
      while (true) {
          System.out.println("1.CRUD project A\t2.Add employee\t3.Delete && Read employee\n" +
                  "4.CRUD task\t5.Assign task\t0. Exit");
          String command = scanStr.nextLine();

          switch (command) {
              case "1" -> {
              ///
              }
              case "2" -> {
                  ///
              }case "3" ->{

              }case "4" ->{
                ///
              }case "5" ->{
                ////
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











    private static void userRole() {
        userService.add(new User("super", "super", "super" , UserRole.SUPER_ADMIN));
        userService.add(new User("admin", "admin", "admin" , UserRole.ADMIN));
        userService.add(new User("manager", "manager", "manager" , UserRole.MANAGER));
        userService.add(new User("tester", "tester", "tester" , UserRole.TESTER));
        userService.add(new User("developer be", "developer be", "developer be" , UserRole.DEVELOPER_BE));
        userService.add(new User("developer fe", "developer fe", "developer fe" , UserRole.DEVELOPER_FE));
    }
}