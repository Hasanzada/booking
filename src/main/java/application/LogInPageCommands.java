package application;

import console.MenuLogIn;
import controller.BookingController;
import controller.FlightController;
import controller.UserController;

import java.util.Scanner;

public class LogInPageCommands {

    private static FlightController flightController = FlightController.getInstance();
    private static BookingController bookingController = BookingController.getInstance();
    private static UserController userController = UserController.getInstance();
    private static final Scanner sc = new Scanner(System.in);

    public static void commands() {
        MenuLogIn.showLogInMenu();
        boolean b = true;
        while (b) {
            String decision = sc.nextLine();
            switch (decision) {
                case "1":
                    MenuLogIn.showLogIn();
                    LoginCommands.logIn();
                    break;
                case "2":
                    MenuLogIn.showRegister();
                    LoginCommands.createAccount();
                    break;
                case "3":
                    userController.saveInFile();
                    flightController.saveInFile();
                    bookingController.saveInFile();
                    b = false;
                    break;
                default:
                    System.out.println("choose 1-3");
                    break;
            }
            if (b)
                MenuLogIn.showLogInMenu();
        }
    }
}
