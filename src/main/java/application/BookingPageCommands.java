package application;

import console.MenuBooking;
import controller.BookingController;
import controller.FlightController;

import java.util.Scanner;


public class BookingPageCommands {

    private static final FlightController flightController = new FlightController();
    private static final BookingController bookingController = new BookingController();
    private static final Scanner sc = new Scanner(System.in);
    public static void commands(){
       MenuBooking.showMenu();
       flightController.genearate();
       boolean b = true;
        while (b) {
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    break;
                case 2:
                    MenuBooking.showFlights();
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
                    MenuBooking.showSelectedFlights();
                    MenuBooking.showBookings();
                    break;
                case 6:
                    b = false;
                    break;
                default:
                    System.out.println("choose 1-6");
                    break;
            }
            if(b)
                MenuBooking.showMenu();
        }

    }
}
