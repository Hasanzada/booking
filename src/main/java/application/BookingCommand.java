package application;

import console.Menu;
import controller.BookingController;
import entity.Booking;
import entity.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingCommand {

    public static void searchFlight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter city");
        String city = sc.nextLine();
        System.out.println("enter date");
        String sdate = sc.nextLine();
        System.out.println("ticket count");
        int ticket_count = sc.nextInt();
        Menu.showSearchedFlight(city, sdate);
        Menu.showBookingYesNo();

        if(sc.hasNextLine()){
            Booking booking = orderBooking(sc.nextInt(),ticket_count);
            if(booking != null){
                BookingController bookingController = new BookingController();
                bookingController.addBooking(booking);
            }
        }else{
            Menu.showBookingAccepted();
            System.out.println("-----------------");
            Menu.showMenu();
        }
    }

    static int booking_id;
    public static Booking orderBooking(int k, int ticket_count) {
        int p_id = 1;
        if (k == 1) {
            System.out.println("Enter flight id");
            Scanner sc = new Scanner(System.in);
            int flight_id =sc.nextInt();
            List<Passenger> passengers = new ArrayList<>();
            for (int i = 0; i < ticket_count; i++) {
                sc = new Scanner(System.in);
                System.out.println("enter passenger name ");
                String name = sc.nextLine();
                System.out.println("enter passenger surname ");
                String surname = sc.nextLine();
                passengers.add( new Passenger(p_id++,name,surname));
            }
            return  new Booking(++booking_id,passengers,flight_id);

        } else {
            Menu.showMenu();
            return null;
        }
    }
}
