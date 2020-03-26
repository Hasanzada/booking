package dao;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAOMemory<A extends Identifiable> implements DAO<A> {

    private final Map<Long, A> storage;

    public DAOMemory(Map<Long, A> map){
        storage = map;
    }

    @Override
    public Optional<A> get(long id) {
        try {
            return Optional.of(storage.get(id));
        } catch (NullPointerException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Collection<A> getAll() {
        try {
            return storage.values();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Collection<A> getAllBy(Predicate<A> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void create(A data) {
        storage.put(data.getId(), data);
    }

    @Override
    public void delete(long id) {
        storage.remove(id);
    }

    @Override
    public void update(A a, long id) {
        deleteByObject(a);
        create(a);
    }

    private void deleteByObject(A a) {
        storage.remove(a);
    }
}
