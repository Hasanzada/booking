package application;

import console.Menu;
import controller.BookingController;
import controller.FlightController;

import java.util.Scanner;


public class Commands {

    private static FlightController flightController = new FlightController();
    private static BookingController bookingController = new BookingController();

    public static void commands(){
       Scanner sc = new Scanner(System.in);
       flightController.genearate();
       boolean b = true;
        while (b) {
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    break;
                case 2:
                    Menu.showFlights();
                    break;
                case 3:
                    BookingCommand.searchFlight();
                    break;
                case 4:
                    System.out.println("select id which you want to delete");
                    int id = sc.nextInt();
                    bookingController.deleteBooking(id);
                    break;
                case 5:
                    Menu.showSelectedFlights();
                    Menu.showBookings();
                    break;
                case 6:
                    b = false;
                default:
                    System.out.println("choose 1-6");
                    break;
            }
            Menu.showMenu();
            sc = new Scanner(System.in);
        }

    }
}
