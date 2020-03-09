package utils;

import entity.Flight;

import java.io.*;
import java.util.*;

public class Utils {

    static ArrayList<Flight> myFlightList = new ArrayList<>();

    public static void addFlight(Flight flight){
        myFlightList.add(flight);
        writeBookToFile(myFlightList, "booking.bin");
    }

    public static List<Flight> getFlightList () {
        return myFlightList;
    }

    public static String getRandomCountry(){
        List<String> countries = CountryList.getAllCountries();
        Random r = new Random();
        return countries.get((int)(Math.random()*countries.size()));
    }

    public static int generateRandomNumber(){
        return (int)(Math.random()*100);
    }

    public static void writeToFile(Map<Integer, Flight> flights, String filename){
        try{
            File file = new File(filename);
            if(!file.exists()) {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(flights);
                oos.close();
                fos.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeBookToFile(Collection<Flight> flights, String filename){
        try{
            File file = new File(filename);
            if(!file.exists()) {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(flights);
                oos.close();
                fos.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Map<Integer, Flight> getFlights(){
        Map<Integer, Flight> flights = new HashMap<>();
        for (int i = 1; i <= 25; i++) {
            Flight flight = new Flight();
            flight.setCountry(Utils.getRandomCountry());
            flight.setDate(new Date());
            flight.setDestination(Utils.getRandomCountry());
            flight.setId(i);
            flight.setSeats(Utils.generateRandomNumber());
            flights.put(flight.getId(), flight);
        }
        return flights;
    }


}
