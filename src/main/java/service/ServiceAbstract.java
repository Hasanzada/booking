package service;

import dao.DAO;
import dao.DAOAbstractFileBin;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/*
public class ServiceAbstract<A> implements Service<A> {

    DAO<A> dao;
    public ServiceAbstract(String filename){
        dao = new DAOAbstractFileBin(filename);
    }


    @Override
    public Optional<A> get(long id) {
        return  dao.get((int) id);
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

    }

    @Override
    public void write(Collection<A> aCollection) {

    }

    @Override
    public Collection<A> read() {
        return null;
    }
*/

//}
