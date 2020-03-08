package application;

import console.Menu;
import console.ReadCommand;
import controller.FlightController;
import entity.Flight;
import service.FlightService;

import javax.naming.ldap.Control;
import java.util.Collection;
import java.util.Scanner;


public class Commands {

    public static void commands(){
       Scanner sc = new Scanner(System.in);
        while (sc.nextInt() < 8) {
            switch (sc.nextInt()) {
                case 1:
                    Menu.showMenu();
                    break;
                case 2:
                    Menu.showFlights();
                    break;
                case 3:
                    Menu.showSearchedFlight(sc.nextInt());
                default:
                    break;
            }
            sc = new Scanner(System.in);
        }

    }
}
