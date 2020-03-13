package application;

import console.MenuBooking;
import controller.BookingController;
import entity.Booking;
import entity.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingCommand {

    public static void searchFlight(long user_id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter city");
        String city = sc.nextLine();

        System.out.println("enter date");
        String sdate = sc.nextLine();

        System.out.println("ticket count");
        int ticket_count = sc.nextInt();

        MenuBooking.showSearchedFlight(city, sdate);
        MenuBooking.showBookingYesNo();

        if(sc.hasNextLine()){
            Booking booking = orderBooking(sc.nextInt(),ticket_count,user_id);
            if(booking != null){
                BookingController bookingController = new BookingController();
                bookingController.addBooking(booking);
            }
        }else{
            MenuBooking.showBookingAccepted();
            System.out.println("-----------------");
            MenuBooking.showMenu();
        }
    }

    public static Booking orderBooking(int k, int ticket_count, long user_id) {
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
            return  new Booking(passengers,flight_id,user_id);

        } else {
            MenuBooking.showMenu();
            return null;
        }
    }
}
