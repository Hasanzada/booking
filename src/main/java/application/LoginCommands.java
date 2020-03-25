package application;

import console.MenuLogIn;
import controller.UserController;
import entity.User;
import utils.Validator;

import java.util.Scanner;

public class LoginCommands {

    private static final Scanner sc = new Scanner(System.in);
    private static UserController userController = UserController.getInstance();

    public static void logIn() {
        System.out.println("Username: ");
        String name = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        if (userController.checkUser(name, password)) {
            MenuLogIn.successfullyLogin();
            long user_id = userController.getUserByNameAndPassword(name, password).getId();
            BookingPageCommands.commands(user_id);
        } else {
            System.out.println("your log in is wrong");
        }
    }

    public static void createAccount() {
        long user_id = userController.users().size() + 1;
        User user = new User(user_id, getUsername(), getPassword());
        userController.addUser(user);
        MenuLogIn.successfullyCreatedLogin();
    }

    public static String getUsername() {
        System.out.println("username: ");
        String name = sc.nextLine();

        while ((!Validator.getValidation(name)) || userController.checkUserByLogin(name)) {
            if (!Validator.getValidation(name)) {
                System.out.println("username must be equal or greater than 5 characters and less than 20 characters");
            }
            if (userController.checkUserByLogin(name)) {
                System.out.println("this username is already taken");
            }
            System.out.println("try new username: ");
            name = sc.nextLine();
        }
        return name;
    }

    public static String getPassword() {
        System.out.println("password: ");
        String password = sc.nextLine();

        while (!Validator.getValidation(password)) {
            System.out.println("password must be equal or greater than 5 characters and less than 20 characters");
            System.out.println("try new password");
            password = sc.nextLine();
        }
        System.out.println("repeat of password: ");
        String password_again = sc.nextLine();

        if (!(password.equals(password_again))) {
            System.out.println("repeat of password is wrong enter passwords again");
            return getPassword();
        } else return password;
    }
}
