package application;

import console.Menu;
import controller.FlightController;


public class Booking {
    public static void main(String[] args) {
        Menu.showMenu();
        FlightController controller = new FlightController();
        controller.controlApp();
    }
}
