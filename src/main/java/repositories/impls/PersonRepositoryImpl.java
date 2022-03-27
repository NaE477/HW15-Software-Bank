package repositories.impls;

import entities.Person;
import repositories.impls.base.BaseRepositoryImpl;
import repositories.interfaces.PersonRepository;

import javax.persistence.EntityManagerFactory;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person> implements PersonRepository {
    public PersonRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<Person> clazz) {
        super(entityManagerFactory, clazz);
    }
}
