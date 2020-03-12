package service;

import dao.DAO;
import dao.DAOAbstractFileBin;
import entity.Flight;
import utils.Utils;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class FlightService {

    private final DAO<Flight> dao = new DAOAbstractFileBin("flights.bin");

    public  void generateFile(){
        File file = new File("flights.bin");
        if(!file.exists()) {
            for (int i = 1; i <= 30; i++) {
                dao.create(Utils.getFlights(i));
            }
        }
    }

    public Collection<Flight> getFlights(){
            return dao.getAll();
    }

    public Flight getFlight(int id){
        return dao.get(id).get();
    }

    public Collection<Flight> flightsByCityAndDate(String city, String date){
        return dao.getAllBy(p -> (p.getCity().equals(city) && p.getDate().equals(date)));
    }

    public void create(Flight flight){
        dao.create(flight);
    }

    public void delete(int id){
        dao.delete(id);
    }

    public List<Flight> getAllBy(Predicate p){
        return (List<Flight>) dao.getAllBy(p);
    }



}