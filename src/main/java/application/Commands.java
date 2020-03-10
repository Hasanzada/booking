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
                    Menu.showMenu();
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
                case 6:
                    b = false;
                default:
                    System.out.println("choose 1-6");
                    Menu.showMenu();
                    break;
            }
            sc = new Scanner(System.in);
        }

    }
}
