package service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public interface Service<A> {

    Optional<A> get(long id);

    Collection<A> getAll();

    Collection<A> getAllBy(Predicate<A> p);

    void create(A a);

    void delete(long id);

    void update(A a, long id);

    void write(Map<Long, A> as);

    Map<Long, A> read();

}
