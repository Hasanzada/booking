package application;

import controller.UserController;
import entity.User;

import java.util.Scanner;

public class LoginCommands {

    private static final Scanner sc = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static int id;

    public static void logIn(){
        System.out.println("Username: ");
        String name = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        if(userController.checkUser(name,password)){
            System.out.println("Log in is successfully");
            long user_id = userController.getUserByNameAndPassword(name,password).getId();
            BookingPageCommands.commands(user_id);
        }else {
            System.out.println("your log in is wrong");

        }
    }

    public static void createAccount(){
        System.out.println("Username: ");
        String name = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        System.out.println("again, Password: ");
        String password_again = sc.nextLine();
        if(password.equals(password_again)){
            User user = new User(++id,name,password);
            userController.addUser(user);
        }else
            createAccount();
    }
}
