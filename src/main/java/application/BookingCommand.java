package application;

import console.MenuBooking;
import controller.BookingController;
import controller.FlightController;
import entity.Booking;
import entity.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingCommand {

    private static FlightController flightController = FlightController.getInstance();

    public static void searchFlight(long user_id) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter destination");
        String city = sc.nextLine();
        System.out.println("enter date");
        String sdate = sc.nextLine();
        System.out.println("ticket count");
        while (!sc.hasNextInt()){
            System.out.println("enter a number not letters, ticket count:");
            sc.next();
        }
        int ticket_count = sc.nextInt();

        if (MenuBooking.showSearchedFlight(city, sdate)) {
            while (!sc.hasNextInt()) {
                System.out.println("enter a number 1-2");
                sc.next();
            }
            Booking booking = orderBooking(sc.nextInt(), ticket_count, user_id);
            if (booking != null) {
                BookingController bookingController = BookingController.getInstance();
                bookingController.addBooking(booking);
                MenuBooking.showBookingAccepted();
            }
        }
    }

    public static Booking orderBooking(int k, int ticket_count, long user_id) {
        int p_id = 1;
        if (k == 1) {
            System.out.println("Enter flight id");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {
                System.out.println("enter a number not letters, flight id:");
                sc.next();
            }
            int flight_id = sc.nextInt();
            List<Passenger> passengers = new ArrayList<>();
            for (int i = 0; i < ticket_count; i++) {
                sc = new Scanner(System.in);
                System.out.printf("enter %d.passenger name: ", i + 1);
                String name = sc.nextLine();
                System.out.printf("enter %d.passenger surname: ", i + 1);
                String surname = sc.nextLine();
                passengers.add(new Passenger(p_id++, name, surname));
            }
            flightController.updateFlight(flight_id, ticket_count);

            return new Booking(passengers, flight_id, user_id);
        } else {
            return null;
        }
    }

    public static void deleteBooking(long user_id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("select id which you want to delete");
        while (!sc.hasNextInt()) {
            System.out.println("enter a number not letters, id:");
            sc.next();
        }
        int id = sc.nextInt();
        BookingController bookingController = BookingController.getInstance();
        System.out.println(bookingController.deleteBooking(id,user_id)? "cancelled successfully":"there is no booking with that id");
    }

    public static void showFlight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter flight id: ");
        while (!sc.hasNextInt()) {
            System.out.println("enter a number not letters, flight id:");
            sc.next();
        }
        long id = sc.nextLong();
        System.out.println(flightController.getFlightById(id));
    }
}
