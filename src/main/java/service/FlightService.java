package service;

import dao.DAOFlightFile;
import dao.FligtDAO;
import entity.Flight;
import utils.GenerateFlightFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FlightService {

    private final DAOFlightFile dao = new DAOFlightFile();

    public  Collection<Flight> getFlights(){
            return dao.getAll();
    }

    public Flight getFlight(int id){
        return dao.get(id);
    }

    public static void writeFile(Map<Integer, Flight> flights){
        try{
            File file = new File("fligths.bin");
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

}

