package service;

import dao.DAO;
import dao.DAOMemory;
import dao.Identifiable;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class ServiceMemory<A> implements Service<A> {

    private DAO<A>dao;
    //private Map<Long, A> list;
    public ServiceMemory(Map<Long,A> list){
        dao = new DAOMemory(list);
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
    public void update(A a, long id){
        dao.update(a, id);
    }

}
