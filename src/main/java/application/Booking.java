package application;

import console.Menu;
import controller.FlightController;
import dao.DAO;
import dao.DAOFlightFile;
import entity.Flight;
import service.FlightService;
import utils.GenerateFlightFile;

import java.util.Collection;

public class Booking {
    public static void main(String[] args) {
        Menu.showMenu();
        FlightController controller = new FlightController();
        controller.controlApp();
    }
}
