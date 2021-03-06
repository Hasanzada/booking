package console;

import controller.BookingController;
import controller.FlightController;
import entity.Flight;

import java.util.Collection;

public class MenuBooking {
    static FlightController flightController = FlightController.getInstance();
    static BookingController bookingController = BookingController.getInstance();

    private static final StringBuilder builder = new StringBuilder();

    public static void showMenu() {
        builder.delete(0, builder.length());
        builder.append("===============================\n");
        builder.append("|         Booking App         |\n");
        builder.append("===============================\n");
        builder.append("| 1. Online board             |\n");
        builder.append("| 2. Show The Flight Info     |\n");
        builder.append("| 3. Search and book a flight |\n");
        builder.append("| 4. Cancel my booking        |\n");
        builder.append("| 5. My flights               |\n");
        builder.append("| 6. Exit                     |\n");
        builder.append("===============================\n");
        System.out.println(builder.toString());
    }

    public static void showFlights() {
        Collection<Flight> all = flightController.getAllFlight();
        all.forEach(System.out::println);
    }

    public static boolean showSearchedFlight(String city, String date) {
        if (flightController.flightsByCityAndDate(city, date).size() == 0) {
            System.out.println("There is no flight as you want, if you want to search again please type 3");
            return false;
        } else {
            MenuBooking.showSelectedBooking();
            flightController.flightsByCityAndDate(city, date).forEach(System.out::println);
            showBookingYesNo();
            return true;
        }
    }

    public static void showSelectedBooking() {
        builder.delete(0, builder.length());
        builder.append("==========================\n");
        builder.append("|      your flight       |\n");
        builder.append("==========================\n");
        System.out.println(builder.toString());
    }

    public static void showBookings(long user_id) {
        bookingController.getAllBookingBy(user_id).forEach(System.out::println);
    }

    public static void showSelectedFlights() {
        builder.delete(0, builder.length());
        builder.append("==========================\n");
        builder.append("|      your bookings     |\n");
        builder.append("==========================\n");
        System.out.print(builder.toString());
    }

    public static void showBookingYesNo() {
        builder.delete(0, builder.length());
        builder.append("==========================\n");
        builder.append("|    1.Booking           |\n");
        builder.append("|    2.Return Main menu  |\n");
        builder.append("==========================\n");
        System.out.println(builder.toString());
    }

    public static void showBookingAccepted() {
        builder.delete(0, builder.length());
        builder.append("=========================\n");
        builder.append("| your booking registred |\n");
        builder.append("=========================\n");
        System.out.println(builder.toString());
    }
}
