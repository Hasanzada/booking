package application;

import console.MenuBooking;
import controller.BookingController;
import controller.FlightController;
import entity.Booking;
import entity.Flight;
import entity.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingCommand {

    private static FlightController flightController = FlightController.getInstance();
    private static BookingController bookingController = BookingController.getInstance();

    public static void searchFlight(long user_id) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter destination");
        String city = sc.nextLine();
        System.out.println("enter date");
        String sdate = sc.nextLine();
        System.out.println("ticket count");
        while (!sc.hasNextInt()) {
            System.out.println("enter a number not letters, ticket count:");
            sc.next();
        }
        int ticket_count = sc.nextInt();

        if (MenuBooking.showSearchedFlight(city, sdate)) {
            while (!sc.hasNextInt()) {
                System.out.println("enter a number 1-2");
                sc.next();
            }
            Booking booking = orderBooking(sc.nextInt(), ticket_count, user_id, city, sdate);
            if (booking != null) {
                BookingController bookingController = BookingController.getInstance();
                bookingController.addBooking(booking);
                MenuBooking.showBookingAccepted();
            }
        }
    }

    public static Booking orderBooking(int k, int ticket_count, long user_id, String city, String sdate) {
        if (k == 1) {
            int p_id = 1;
            System.out.println("Enter flight id");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {
                System.out.println("enter a number not letters, flight id:");
                sc.next();
            }
            int flight_id = sc.nextInt();
            Flight flight = flightController.getFlight(flight_id);
            if(flight.getSeats() == 0){
                System.out.println("all seats already reserved search another flight");
                searchFlight(user_id);
                throw new IllegalArgumentException("something get wrong");
            }else if(flight.getSeats() < ticket_count){
                System.out.println("not enough seats reserve again");
                searchFlight(user_id);
                throw new IllegalArgumentException("something get wrong");
            }else {
                List<Passenger> passengers = new ArrayList<>();
                for (int i = 0; i < ticket_count; i++) {
                    sc = new Scanner(System.in);
                    System.out.printf("enter %d.passenger name: ", i + 1);
                    String name = sc.nextLine();
                    System.out.printf("enter %d.passenger surname: ", i + 1);
                    String surname = sc.nextLine();
                    passengers.add(new Passenger(p_id++, name, surname));
                }

                flightController.updateFlightafterBooking(flight_id, ticket_count);
                int id = bookingController.getAllBookingBy(user_id).size() + 1;
                return new Booking(id, passengers, flight_id, user_id);
            }
        }else
            throw new IllegalArgumentException("something get wrong");
    }

    public static void deleteBooking(long user_id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("select id which you want to delete");
        while (!sc.hasNextInt()) {
            System.out.println("enter a number not letters, id:");
            sc.next();
        }
        int id = sc.nextInt();
        Booking booking = bookingController.getBook(id);
        System.out.println(bookingController.deleteBooking(id, user_id) ? "cancelled successfully" : "there is no booking with that id");
        flightController.updateFlightafterCancel(booking.getFlight_id(), booking.getPassengers().size());
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
