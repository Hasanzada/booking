package controller;

import application.Commands;
import entity.Flight;
import service.FlightService;

import java.util.Collection;


public class FlightController {

    private FlightService flightService = new FlightService();

    public Collection<Flight> getAllFlight(){
        return flightService.getFlights();
    }

    public Flight getFlight(int id){
        return flightService.getFlight(id);
    }


}
