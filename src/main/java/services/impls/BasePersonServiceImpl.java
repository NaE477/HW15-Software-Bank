package services.impls;

import entities.Person;
import repositories.interfaces.BasePersonRepository;
import services.interfaces.BasePersonService;

public abstract class BasePersonServiceImpl<T extends Person> extends BaseServiceImpl<T, BasePersonRepository<T>> implements BasePersonService<T> {
    public BasePersonServiceImpl(BasePersonRepository<T> repository) {
        super(repository);
    }

    @Override
    public T findByUsername(String username) {
        return repository.readByUsername(username);
    }
}
