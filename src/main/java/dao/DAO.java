package dao;

import java.util.Collection;

public interface DAO<A> {
    A get(int id);
    Collection<A> getAll();
    void create(A a);
    void delete(int id);
}
