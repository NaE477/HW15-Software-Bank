package repositories.impls;

import entities.Person;
import repositories.impls.base.BasePersonRepositoryImpl;
import repositories.interfaces.PersonRepository;

import javax.persistence.EntityManagerFactory;

public class PersonRepositoryImpl extends BasePersonRepositoryImpl<Person> implements PersonRepository {
    public PersonRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<Person> clazz) {
        super(entityManagerFactory, clazz);
    }
}
