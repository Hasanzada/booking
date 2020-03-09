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
       boolean b = true;
        while (b) {
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    Menu.showMenu();
                    break;
                case 2:
                    Menu.showFlights();
                    break;
                case 3:
                    Menu.showSelectedBooking();
                    Menu.showSearchedFlight(i);
                    break;
                default:
                    b = false;
                    break;
            }
            sc = new Scanner(System.in);
        }

    }
}
