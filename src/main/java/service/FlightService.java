package service;

import dao.DAO;
import dao.DAOFlightFile;
import entity.Flight;
import java.util.Collection;
import java.util.Map;

import utils.GenerateFlightFile;
import utils.Utils;

public class FlightService {

    private final DAO<Flight> dao = new DAOFlightFile();

    public  Collection<Flight> getFlights(){
            writeFlightFile(GenerateFlightFile.getFlights());
            return dao.getAll();
    }

    public Flight getFlight(int id){
        return dao.get(id);
    }

    public static void writeFlightFile(Map<Integer, Flight> flights){
        Utils.writeToFile(flights,"flight.bin");
    }


    public static void writeBookingFile(Map<Integer, Flight> flights){
        Utils.writeToFile(flights,"bookings.bin");
    }


}

