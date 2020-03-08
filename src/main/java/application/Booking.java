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
        /*DAO<Flight> dao = new FligtDAO();
        Collection<Flight> all = dao.getAll();
        all.forEach(p -> System.out.println(p));
*/
        FlightService.writeFile(GenerateFlightFile.getFlights());
        DAO<Flight> dao = new DAOFlightFile();
        Collection<Flight> all = dao.getAll();
        all.forEach(p -> System.out.println(p));
    }
}
