package console;

import controller.BookingController;
import controller.FlightController;
import entity.Booking;
import entity.Flight;

import java.util.Collection;

public class MenuBooking {
    static FlightController flightController = new FlightController();
    static BookingController bookingController = new BookingController();

    private static final StringBuilder builder = new StringBuilder();
    public static void showMenu(){
        builder.delete(0,builder.length());
        builder.append(" =============================\n");
        builder.append("|         Booking App         |\n");
        builder.append(" =============================\n");
        builder.append("| 1. Online board             |\n");
        builder.append("| 2. Show The Flight Info     |\n");
        builder.append("| 3. Search and book a flight |\n");
        builder.append("| 4. Cancel my booking        |\n");
        builder.append("| 5. My flights               |\n");
        builder.append("| 6. Exit                     |\n");

        System.out.println(builder.toString());
    }

    public static void showFlights(){
        Collection<Flight> all = flightController.getAllFlight();
        all.forEach(p -> System.out.println(p));
    }

    public static void showSearchedFlight(String city, String date){
        MenuBooking.showSelectedBooking();
        System.out.println(flightController.flightsByCityAndDate(city,date));
        //bookingController.addBooking(flightController.getFlight(id));
    }

    public static void showSerchedBooking(){
        builder.delete(0,builder.length());
        builder.append("=========================\n");
        builder.append("| select your flight     |\n");
        builder.append("=========================\n");
        System.out.println(builder.toString());
    }

    public static void showSelectedBooking(){
        builder.delete(0,builder.length());
        builder.append("=========================\n");
        builder.append("|      your flight       |\n");
        builder.append("=========================\n");
        System.out.println(builder.toString());
    }

    public static void showBookings(){
        Collection<Booking> all = bookingController.getAllBooking();
        all.forEach(p -> System.out.println(p));
    }

    public static void showSelectedFlights(){
        builder.delete(0,builder.length());
        builder.append("=========================\n");
        builder.append("|      your bookings     |\n");
        builder.append("=========================\n");
        System.out.println(builder.toString());
    }

    public static void showBookingYesNo(){
        builder.delete(0,builder.length());
        builder.append("=========================\n");
        builder.append("|    1.Booking           |\n");
        builder.append("|    2.Return Main menu  |\n");
        builder.append("=========================\n");
        System.out.println(builder.toString());
    }


    public static void showBookingAccepted() {
        builder.delete(0,builder.length());
        builder.append("=========================\n");
        builder.append("| your booking registred |\n");
        builder.append("=========================\n");
        System.out.println(builder.toString());
    }
}
