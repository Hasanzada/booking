package controller;

import entity.Flight;
import service.Service;
import service.ServiceAbstract;
import utils.Utils;

import java.io.File;
import java.util.Collection;


public class FlightController {


    Service<Flight> service = new ServiceAbstract<>("flights.bin");
    public  void generateFile(){
        File file = new File("flights.bin");
        if(!file.exists()) {
            for (int i = 1; i <= 30; i++) {
                service.create(Utils.getFlights(i));
            }
        }
    }


    public void genearate(){
        generateFile();
    }

    public String getById(int id) {
        return getFlightById(id);
    }

    public String getFlightById(int id) {
        return service.get(id).map(Flight::toString).orElse("There is no Flight with that id");
    }

    public Collection<Flight> getAllFlight(){
        return service.getAll();
    }

    public Collection<Flight> flightsByCityAndDate(String city, String date){
        return service.getAllBy(p -> (p.getDestination().equals(city) && p.getDate().equals(date)));
    }

    public Flight getFlight(int id){
        return service.get(id).get();
    }
}
