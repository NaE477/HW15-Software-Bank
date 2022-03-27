package services.impls;

import entities.Person;
import repositories.interfaces.PersonRepository;
import services.impls.base.BaseServiceImpl;
import services.interfaces.PersonService;

public class PersonServiceImpl extends BaseServiceImpl<Person,PersonRepository> implements PersonService {
    public PersonServiceImpl(PersonRepository repository) {
        super(repository);
    }
}
