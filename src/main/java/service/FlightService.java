package service;

import dao.DAO;
import dao.DAOAbstractFileBean;
import entity.Flight;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class FlightService {

    private final DAO<Flight> dao = new DAOAbstractFileBean("flight.bin");

    public Collection<Flight> getFlights(){
        if(dao.getAll() == null){

        }
            return dao.getAll();
    }

    public Flight getFlight(int id){
        return dao.get(id).get();
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