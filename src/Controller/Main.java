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
import static Controller.ManagerController.*;
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
            System.out.println();
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
            System.out.println();
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
          System.out.println();
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
          System.out.println();
          System.out.println("1.CRUD project\t2.Employee menu\t3.CRUD task\t4.Assign task\t0. Exit");
          String command = scanStr.nextLine();

          switch (command) {
              case "1" -> {
              projectMenu();
              }
              case "2" -> {
                  employeeMenu();
              }case "3" ->{
                   taskMenu();
              }case "4" ->{
                assignTask();
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

    private static void taskMenu() {
        while (true) {
            System.out.println();
            System.out.println("\t1.Create\t2.show task\t3.Update\t4.Delete\t0.Exit");
            String command = scanStr.nextLine();
            switch (command) {
                case "1" -> {
                    createTask();
                }
                case "2" -> {
                    showTasks();
                }
                case "3" -> {
                     updateTask();
                }
                case "4" -> {
                     deleteTask();
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

    private static void employeeMenu() {
        while (true) {
            System.out.println();
            System.out.println("1.Add employee\t2.Read employee\t3.Delete employee\t0. Exit");
            String command = scanStr.nextLine();

            switch (command) {
                case "1" -> {
                addEmployee();
                }
                case "2" -> {
                    showEmployeebyManagerId();
                }case "3" ->{
                    deleteEmployer();
                }case "0" -> {
                    System.out.println("thank you for choosing us\n\n");
                    return;
                }
                default -> {
                    System.out.println("Sorry?!");
                }
            }
        }
    }

    private static void projectMenu() {
        while (true) {
            System.out.println();
            System.out.println("\t1.Create\t2.show project\t3.Update\t4.Delete\t0.Exit");
            String command = scanStr.nextLine();
            switch (command) {
                case "1" -> {
                    createProject();
                }
                case "2" -> {
                    showAllpreject();
                }
                case "3" -> {
                    updateProject();
                }
                case "4" -> {
                    deleteProject();
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
        private static void userRole () {
            userService.add(new User("super", "super", "super", UserRole.SUPER_ADMIN));
            userService.add(new User("admin", "admin", "admin", UserRole.ADMIN));
            userService.add(new User("manager", "manager", "manager", UserRole.MANAGER));
            userService.add(new User("tester", "tester", "tester", UserRole.TESTER));
            userService.add(new User("developer be", "developer be", "developer be", UserRole.DEVELOPER_BE));
            userService.add(new User("developer fe", "developer fe", "developer fe", UserRole.DEVELOPER_FE));
        }

}