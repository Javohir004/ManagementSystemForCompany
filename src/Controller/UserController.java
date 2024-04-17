package Controller;

import Enomerator.UserRole;
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

        if (userService.add(new User(name, username, password , UserRole.ADMIN)) == 1) {
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

        System.out.println("Welcome " + currentUser.getUsername().toUpperCase() + "!\n\n");

        mainMenuUser();
    }

    public static void showUsers(ArrayList<User> users) {
        int i = 1;
        for (User user : users) {
            if (user != currentUser) {
                System.out.println(i++ + ". " + user.toString());
            }
        }
        System.out.print("Choose one: ");
        i = scanNum.nextInt() - 1;
        User user = users.get(i);
    }


}



