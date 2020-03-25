package application;

import console.MenuBooking;
import controller.BookingController;
import controller.FlightController;
import controller.UserController;

import java.util.Scanner;

public class BookingPageCommands {

    private static FlightController flightController = FlightController.getInstance();
    private static BookingController bookingController = BookingController.getInstance();
    private static UserController userController = UserController.getInstance();
    private static final Scanner sc = new Scanner(System.in);

    public static void commands(long user_id) {
        MenuBooking.showMenu();
        flightController.genearate();
        boolean b = true;
        while (b) {
            String decision = sc.nextLine();
            switch (decision) {
                case "1":
                    MenuBooking.showFlights();
                    break;
                case "2":
                    BookingCommand.showFlight();
                    break;
                case "3":
                    BookingCommand.searchFlight(user_id);

                    break;
                case "4":
                    MenuBooking.showBookings(user_id);
                    BookingCommand.deleteBooking(user_id);
                    break;
                case "5":
                    MenuBooking.showSelectedFlights();
                    MenuBooking.showBookings(user_id);
                    break;
                case "6":
                    bookingController.saveInFile();
                    b = false;
                    break;
                default:
                    System.out.println("choose 1-6");
                    break;
            }
            if (b)
                MenuBooking.showMenu();
        }
    }
}
