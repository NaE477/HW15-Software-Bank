package repositories.interfaces.base;

import entities.Person;

public interface BasePersonRepository<T extends Person> extends BaseRepository<T> {
    T readByUsername(String username);
}
