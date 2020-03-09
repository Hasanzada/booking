package application;

import console.Menu;

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
                    Menu.showSerchedBooking();
                    Menu.showSearchedFlight(sc.nextInt());
                    break;
                case 4:

                    break;
                case 5:
                    Menu.showSelectedFlights();
                    Menu.showBookings();

                    break;
                default:
                    b = false;
                    break;
            }
            sc = new Scanner(System.in);
        }

    }
}
