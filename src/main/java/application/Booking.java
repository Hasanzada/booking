package application;

import console.Menu;
import controller.Controller;
import controller.FlightController;


public class Booking {
    public static void main(String[] args) {
        Menu.showMenu();
        Controller controller = new Controller();
        controller.controlApp();
    }
}
