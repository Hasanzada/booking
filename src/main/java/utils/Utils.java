package utils;

import entity.Flight;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utils {

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
}
