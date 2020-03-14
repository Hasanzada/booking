package application;

import console.MenuBooking;
import console.MenuLogIn;
import controller.BookingController;
import controller.FlightController;

import java.util.Scanner;


public class LogInPageCommands {

    private static FlightController flightController = new FlightController();
    private static BookingController bookingController = new BookingController();
    private static final Scanner sc = new Scanner(System.in);
    public static void commands(){

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
