package service;

import dao.DAO;
import dao.DAOMemory;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class ServiceMemory<A> implements Service<A> {

    private File file;
    private DAO<A> dao;

    public ServiceMemory(String filename, Map<Long,A>map) {
        file = new File(filename);
        dao = new DAOMemory(map);
    }


    @Override
    public Optional<A> get(long id) {
        return dao.get(id);
    }

    @Override
    public Collection<A> getAll() {
        return dao.getAll();
    }

    @Override
    public Collection<A> getAllBy(Predicate<A> p) {
        return dao.getAllBy(p);
    }

    @Override
    public void create(A a) {
        dao.create(a);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void update(A a, long id) {
        dao.update(a, id);
    }

    @Override
    public void write(Map<Long, A> as) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(as);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }

    @Override
    public Map<Long, A> read() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            Object readed = ois.readObject();
            Map<Long, A> as = (Map<Long, A>) readed;
            return as;
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Deserialization error. Didn't you forget to include 'serialVersionUID field' in your entity?", ex);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return new HashMap<>();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Something went wrong", ex);
        }
    }

}
