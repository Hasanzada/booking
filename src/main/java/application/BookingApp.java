package application;

import console.Menu;
import controller.Controller;


public class BookingApp {
    public static void main(String[] args) {
        Menu.showMenu();
        Controller controller = new Controller();
        controller.controlApp();

    }
}