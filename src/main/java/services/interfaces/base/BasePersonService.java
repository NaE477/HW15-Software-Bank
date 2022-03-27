package services.interfaces.base;

import entities.Person;

public interface BasePersonService<T extends Person> extends BaseService<T> {
    T findByUsername(String username);
}
