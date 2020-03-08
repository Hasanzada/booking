package console;

import controller.FlightController;
import entity.Flight;

import java.util.Collection;

public class Menu {
    static FlightController controller = new FlightController();

    public static void showMenu(){
        StringBuilder builder = new StringBuilder();
        builder.append(" ===========================\n");
        builder.append("|        Booking App        |\n");
        builder.append(" ===========================\n");
        builder.append("| 1. Show Menu              |\n");
        builder.append("| 2. Show Time Table        |\n");
        builder.append("| 3. Search for a flight    |\n");
        builder.append("| 4. Make a booking         |\n");
        builder.append("| 5. Show my booking        |\n");
        builder.append("| 6. Cancel my booking      |\n");
        builder.append("| 7. Log out                |\n");
        builder.append("| 8. Exit                   |\n");

        System.out.println(builder.toString());
    }

    public static void showFlights(){
        Collection<Flight> all = controller.getAllFlight();
        all.forEach(p -> System.out.println(p));
    }

    public static void showSearchedFlight(int id){
        System.out.println(controller.getFlight(id));
    }


}
