package services.impls.base;

import entities.Person;
import repositories.interfaces.base.BasePersonRepository;
import services.interfaces.base.BasePersonService;

public abstract class BasePersonServiceImpl<T extends Person> extends BaseServiceImpl<T, BasePersonRepository<T>> implements BasePersonService<T> {
    public BasePersonServiceImpl(BasePersonRepository<T> repository) {
        super(repository);
    }

    @Override
    public T findByUsername(String username) {
        return repository.readByUsername(username);
    }
}
