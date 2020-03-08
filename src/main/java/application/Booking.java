package application;

import console.Menu;
import dao.DAO;
import dao.DAOFlightFile;
import entity.Flight;
import service.FlightService;
import utils.GenerateFlightFile;

import java.util.Collection;

public class Booking {
    public static void main(String[] args) {
        System.out.println(Menu.showMenu());

        //FlightService.writeFile(GenerateFlightFile.getFlights());
        FlightService flightService = new FlightService();
        Collection<Flight> all = flightService.getFlights();
        all.forEach(p -> System.out.println(p));

        System.out.println(flightService.getFlight(5));
    }
}
