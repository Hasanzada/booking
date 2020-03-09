package console;

import controller.FlightController;
import entity.Flight;

import java.util.Collection;

public class Menu {
    static FlightController controller = new FlightController();

    public static void showMenu(){
        StringBuilder builder = new StringBuilder();
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
        Collection<Flight> all = controller.getAllFlight();
        all.forEach(p -> System.out.println(p));
    }

    public static void showSearchedFlight(int id){
        System.out.println(controller.getFlight(id));
    }

    public static void showSelectedBooking(){
        StringBuilder builder = new StringBuilder();
        builder.append("=========================\n");
        builder.append("|      your booking      |\n");
        builder.append("=========================\n");
        System.out.println(builder.toString());
    }

}
