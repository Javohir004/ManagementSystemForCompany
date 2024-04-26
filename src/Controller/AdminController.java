package Controller;

import Enomerator.UserRole;
import model.Block;
import model.User;

import java.util.ArrayList;

import static Controller.Main.*;

public class AdminController {

  public static void   stopManager(){
  ArrayList<User> managerList = showManager();

      System.out.print("Choose the index : ");
      int index = scanNum.nextInt()-1;

      if(index < 0 || index >= managerList.size()){
          System.out.println("Something went wrong !!!");
          return;
      }

      User user = managerList.get(index);
      System.out.println(user.getId());
      if( blockService.block( new Block(user.getId())) == 1 ){
          user.setActive(false);
          System.out.println(user.getUsername() + " is blocked !!!");
      }else{
          System.out.println("Something went wrong !!!");
      }

    }


   public static void removeManager(){
   ArrayList<User>delete = showManager();

       System.out.print("Choose the index : ");
       int index = scanNum.nextInt()-1;

       if(index < 0 || index >= delete.size()){
           System.out.println("Something went wrong !!!");
           return;
       }

       User user = delete.get(index);
       userService.delete(user.getId());
      }



   public static void addManager(){

       System.out.print("Enter name : ");
       String name = scanStr.nextLine();

       System.out.print("Enter username: ");
       String username = scanStr.nextLine();

       System.out.print("Enter password: ");
       String password = scanStr.nextLine();

       if (userService.add(new User(name, username, password , UserRole.MANAGER)) == 1) {
           System.out.println("New manager added !!!");
       }else {
           System.out.println("This manager already exist !!!");
       }
    }

    public static ArrayList<User> showManager(){
        ArrayList<User>managers = userService.getUsersByRole(UserRole.MANAGER);
        int i=0;
        for (User manager : managers) {
            System.out.println(++i + " - " + manager.getUsername());
        }
        return managers;
    }

    public static void restartManager() {
        ArrayList<User> blocked = userService.getBlockedUser(UserRole.MANAGER);
        int i = 0;
        for (User user : blocked) {
            System.out.println(++i + " - " + user.getUsername());
        }

        System.out.print("Choose the index : ");
        int index = scanNum.nextInt() - 1;

        if (index < 0 || index >= blocked.size()) {
            System.out.println("Something went wrong !!!");
            return;
        }

        User user = blocked.get(index);
        if (blockService.unblock(new Block(user.getId())) == 1) {
            user.setActive(true);
            System.out.println("Succesfully restarted !!! ");
        } else {
            System.out.println("Something went wrong !!!");
        }
    }

}
