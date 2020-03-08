package dao;

import entity.Flight;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class DAOFlightFile implements DAO<Flight> {


  private String filename;

  public DAOFlightFile(String filename) {
    this.filename = filename;
  }

  public DAOFlightFile() {

  }

  @Override
  public Flight get(int id) {
    return getAll()
        .stream()
        .filter(p -> p.getId()==id)
        .findFirst()
        .orElseThrow(() -> new RuntimeException("not found"));
  }

  @Override
  public Collection<Flight> getAll() {
    HashMap<Integer, Flight> flights = new HashMap<>();
    try {
      File file = new File("fligths.bin");
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);
      flights = (HashMap<Integer, Flight>) ois.readObject();
      ois.close();
      fis.close();
    } catch (Exception e) {
      throw new RuntimeException("smth went wrong during pizza creation");
    }
    return  flights.values();
  }

  @Override
  public void create(Flight flight) {
    try {
      /*BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename), true));
      bw.write(pizza.represent());
      bw.write("\n");
      bw.close();*/
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("flight.bin")));
      oos.write(flight.getId());
      oos.writeObject(flight.getCountry());

    } catch (IOException e) {
      throw new RuntimeException("smth went wrong during pizza creation");
    }
  }

  @Override
  public void delete(int id) {
    /*try {

    } catch (IOException e) {
      throw new RuntimeException("smth went wrong during pizza creation");
    }*/
  }
}
