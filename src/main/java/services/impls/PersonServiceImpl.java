package services.impls;

import entities.Person;
import repositories.interfaces.base.BasePersonRepository;
import services.impls.base.BasePersonServiceImpl;
import services.interfaces.PersonService;

public class PersonServiceImpl extends BasePersonServiceImpl<Person> implements PersonService {
    public PersonServiceImpl(BasePersonRepository<Person> repository) {
        super(repository);
    }
}
