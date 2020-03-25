package dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<A> {
    Collection<A> getAll();

    Collection<A> getAllBy(Predicate<A> p);

    Optional<A> get(long id);

    void create(A data);

    void delete(long id);

    void update(A a, long id);
}
